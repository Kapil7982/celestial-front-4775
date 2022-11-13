package com.universal_pay.service;

import java.lang.StackWalker.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.AccountException;
import com.universal_pay.exception.WalletException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;
import com.universal_pay.repo.AccountRepo;
import com.universal_pay.repo.WalletRepository;

@Service
public class IAccountServiceImpl implements IAccountService{
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private WalletRepository wRepo;

	@Override
	public Wallet addAccount(BankAccount bacc) throws AccountException, WalletException {
		
		
		Wallet w = bacc.getWallet();
		if(w != null) {
			
			Optional<Wallet> optWallet = wRepo.findById(w.getWalletId());
			
			if(optWallet.isPresent()) {
				Wallet wallet = optWallet.get();
				
				wallet.getBankAccounts().add(bacc);
				BigDecimal bal = new BigDecimal(bacc.getBalance());
				
				wallet.setBalance(wallet.getBalance().add(bal));
				aRepo.save(bacc);
								
				return wRepo.save(wallet);
			}else {
				throw new WalletException("Invalid wallet id...");
			}
			
		}else {
			throw new AccountException("No wallet id found...");
		}
		
	}

	@Override
	public Wallet removeAccount(Integer walletId, Integer bankAccId) throws AccountException {
		
		Wallet wallet  = wRepo.findById(walletId).orElseThrow(()-> new AccountException("Wallet not found"));
		for(BankAccount account: wallet.getBankAccounts()) {
			if(account.getAccountNo().equals(bankAccId)) {
				aRepo.delete(account);
				break;
			}
		}
		return wallet;
//		BankAccount bAccount = null;
//		
//		Optional<BankAccount> optAccount = aRepo.findById(bacc.getAccountNo());
//		
//		if(optAccount.isPresent()) {
//			bAccount = optAccount.get();
//			aRepo.delete(bAccount);
//		}
//		else {
//			throw new AccountException("No account found..");
//		}
//		return bAccount.getWallet();
	}

	@Override
	public Set<BankAccount> viewAllAccounts(Wallet wallet) throws WalletException {
		Optional<Wallet> w = wRepo.findById(wallet.getWalletId());
		
		if(w.isPresent()) {
			
			return (Set<BankAccount>) w.get().getBankAccounts();
			
		}else {
			throw new WalletException("Invalid wallet id..");
		}
	}

	





}
