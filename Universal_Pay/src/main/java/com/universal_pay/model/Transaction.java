package com.universal_pay.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*


{
"transactionId" : "2380",
"transactionType" : "shopping"

}


*/

@Entity
public class Transaction {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private String transactionType;
	private LocalDate transactionDate;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY )
	@JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
	@JsonIgnore
	private Wallet wallet;
	
	private double amount;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "account_no", referencedColumnName = "accountNo")
	private BankAccount bankAccount;

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, String transactionType, LocalDate transactionDate, Wallet wallet, double amount,
			String description, BankAccount bankAccount) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.wallet = wallet;
		this.amount = amount;
		this.description = description;
		this.bankAccount = bankAccount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
}
