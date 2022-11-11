package com.universal_pay.service;

import java.util.List;

import com.universal_pay.exception.AccountException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;

public interface IAccountService {
	
	public Wallet addAccount(BankAccount bacc) throws AccountException;
	
	public Wallet removeAccount(BankAccount bacc) throws AccountException;
	
	public BankAccount viewAccount(Wallet wallet) throws AccountException;
	
	public List<BankAccount> viewAllAccounts(Wallet wallet) throws AccountException;
	

}
