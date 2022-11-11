package com.universal_pay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.AccountException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;
import com.universal_pay.repo.AccountRepo;

@Service
public class IAccountServiceImpl implements IAccountService{
	
	@Autowired
	private AccountRepo aRepo;

	@Override
	public Wallet addAccount(BankAccount bacc) throws AccountException {
		
		
//		Wallet wallet = bacc.getWallet();
		BankAccount savedAccount = aRepo.save(bacc);
		
		if(savedAccount != null) {
			return savedAccount.getWallet();
		}else {
			throw new AccountException("No account created....");
		}
	}

	@Override
	public Wallet removeAccount(BankAccount bacc) throws AccountException {
		
		BankAccount bAccount = null;
		
		Optional<BankAccount> optAccount = aRepo.findById(bacc.getAccountNo());
		
		if(optAccount.isPresent()) {
			bAccount = optAccount.get();
			aRepo.delete(bAccount);
		}
		else {
			throw new AccountException("No account found..");
		}
		return bAccount.getWallet();
	}

	@Override
	public BankAccount viewAccount(Wallet wallet) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BankAccount> viewAllAccounts(Wallet wallet) throws AccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
