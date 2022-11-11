package com.universal_pay.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BillPayment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private BillType billtype;
	private double amount;
	private LocalDate paymentDate;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
	private Wallet wallet;

	public BillPayment() {
		super();
	}

	public BillPayment(int billId, BillType billtype, double amount, LocalDate paymentDate, Wallet wallet) {
		super();
		this.billId = billId;
		this.billtype = billtype;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.wallet = wallet;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public BillType getBilltype() {
		return billtype;
	}

	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
}
