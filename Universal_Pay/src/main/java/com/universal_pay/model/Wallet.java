package com.universal_pay.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;
	private BigDecimal balance;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BankAccount> bankAccounts;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Transaction> transcations;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BillPayment> billPayments;
	
	@OneToMany(mappedBy = "wallet" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<BeneficiaryDetails> benificiaryDetails;

	public Wallet() {
		super();
	}

	public Wallet(int walletId, BigDecimal balance, List<BankAccount> bankAccounts, List<Transaction> transcations,
			List<BillPayment> billPayments, List<BeneficiaryDetails> benificiaryDetails) {
		super();
		this.walletId = walletId;
		this.balance = balance;
		this.bankAccounts = bankAccounts;
		this.transcations = transcations;
		this.billPayments = billPayments;
		this.benificiaryDetails = benificiaryDetails;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Transaction> getTranscations() {
		return transcations;
	}

	public void setTranscations(List<Transaction> transcations) {
		this.transcations = transcations;
	}

	public List<BillPayment> getBillPayments() {
		return billPayments;
	}

	public void setBillPayments(List<BillPayment> billPayments) {
		this.billPayments = billPayments;
	}

	public List<BeneficiaryDetails> getBenificiaryDetails() {
		return benificiaryDetails;
	}

	public void setBenificiaryDetails(List<BeneficiaryDetails> benificiaryDetails) {
		this.benificiaryDetails = benificiaryDetails;
	}
	
	
	
	
	
	
}
