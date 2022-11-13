package com.universal_pay.service;

import java.time.LocalDate;
import java.util.List;

import com.universal_pay.model.Transaction;
import com.universal_pay.model.Wallet;

public interface ITransactionService {

	public Transaction addTransaction (Transaction tran) throws Exception;
	public List<Transaction> viewAllTransactionsByWalletId(Integer walletId) throws Exception;
	public List<Transaction> viewTransactionsByDate(LocalDate from,LocalDate to) throws Exception;
	public List<Transaction> viewAllTransactions(String type) throws Exception;
}
