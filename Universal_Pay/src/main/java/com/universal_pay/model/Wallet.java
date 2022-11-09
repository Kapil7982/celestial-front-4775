package com.universal_pay.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walledId;
	private BigDecimal balance;
	
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet(BigDecimal amount) {
		this.balance=amount;
	}

	public int getWalledId() {
		return walledId;
	}

	public void setWalledId(int walledId) {
		this.walledId = walledId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [walledId=" + walledId + ", balance=" + balance + "]";
	}

	
	
	
	
	
}
