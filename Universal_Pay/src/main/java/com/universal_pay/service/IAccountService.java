package com.universal_pay.service;

import java.util.List;
import java.util.Set;

import com.universal_pay.exception.AccountException;
import com.universal_pay.exception.WalletException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;

public interface IAccountService {
	
	public Wallet addAccount(BankAccount bacc) throws AccountException,WalletException;
	
	public Wallet removeAccount(Integer walletId, Integer bankAccId) throws AccountException;
	
//	public Wallet removeAccount(Integer accNo)throws AccountException;
	
//	public BankAccount viewAccount(Wallet wallet) throws WalletException;
	
	public Set<BankAccount> viewAllAccounts(Wallet wallet) throws WalletException;
	

}
