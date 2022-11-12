package com.universal_pay.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.CustomerException;
import com.universal_pay.model.BankAccount;

import com.universal_pay.model.Customer;
import com.universal_pay.model.Transaction;
import com.universal_pay.model.Wallet;
import com.universal_pay.repo.AccountRepo;
import com.universal_pay.repo.CustomerRepo;
import com.universal_pay.repo.IUserRepo;
import com.universal_pay.repo.WalletRepository;


@Service("WalletService")
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	WalletRepository walletRepo;
	
	@Autowired
	AccountRepo iAccountRepository;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	IUserRepo iUserRepo;

	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) throws CustomerException {


		Optional<Customer> customer = customerRepo.findById(mobileno);
		
		if (!customer.isPresent()) {
			throw new CustomerException("No customer found for the mobile no :"+mobileno);		
		}
		else if (customer.get().getWallet() == null) {
			Wallet w = new Wallet();
			w.setBalance(amount);
			walletRepo.save(w);
			customer.get().setWallet(w);
			iUserRepo.save(customer.get());
			return customer.get();
		} 
		else {
			throw new CustomerException("Wallet is already Present for the mobileno");
		}
	}


	@Override
	public Customer showBalance(String mobileno) throws Exception {
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNumber().equals(mobileno)) {
					return i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		return null;
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) throws Exception {
		Customer  sender = null;
		Customer  reciever = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNumber().equals(sourceMobileNo)) {
					sender = i;
				}
				else if(i.getMobileNumber().equals(targetMobileNo)) {
					reciever = i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		sender.getWallet().setBalance(sender.getWallet().getBalance().subtract(new BigDecimal(amount)));
		reciever.getWallet().setBalance(reciever.getWallet().getBalance().add(new BigDecimal(amount)));
		return sender;
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) throws Exception {
		Customer  reciever = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNumber().equals(mobileNo)) {
					reciever = i;
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Customer details not found");
		}
		reciever.getWallet().setBalance(reciever.getWallet().getBalance().add(new BigDecimal(amount)));
		return reciever;
	}

	

	@Override
	public List<Customer> getList() throws Exception {
		return iUserRepo.findAll();
	}

	@Override
	public Customer updateAccount(Customer customer) throws Exception {
		Customer  bean = null;
		try {
			bean = iUserRepo.findBymobileNumber(customer.getMobileNumber());
		}
		catch(Exception e) {
			throw new Exception("Customer details not found!");
		}
		iUserRepo.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Wallet addMoney(Wallet wallet, double amount) throws Exception {
//		Wallet  bean = null;
//		try {
//			bean = walletRepo.findById(wallet.getWalletId()).get();
//		}
//		catch(Exception e) {
//			throw new Exception("Wallet details not found!");
//		}
		Optional<Wallet> w = walletRepo.findById(wallet.getWalletId());
		if(w.isPresent()) {
			

			Wallet w1 = w.get();
			
			w1.setBalance(w1.getBalance().add(new BigDecimal(amount)));
			
			return walletRepo.save(w1);
			
			
			
		}else {
			throw new Exception("Wallet details not found!");

			
		}
		

	}

	
	

}
