package com.universal_pay.service;
import java.math.BigDecimal;
import java.util.List;

import com.universal_pay.exception.CustomerException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Customer;
import com.universal_pay.model.Wallet;


public interface WalletService {
	
//	public Customer createAccount(BankAccount acc) throws CustomerException;
	
	public Customer showBalance (String mobileno) throws Exception;
	
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws Exception;
	
	public Customer depositAmount (String mobileNo,double amount ) throws Exception;
	
	public List<Customer> getList() throws Exception;
	
	public Customer updateAccount(Customer customer) throws Exception;
	
	public Wallet addMoney(Wallet wallet, double amount) throws Exception;

}
