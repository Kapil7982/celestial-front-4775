package com.universal_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Transaction {

	    @Id
	    @GeneratedValue(strategy =GenerationType.AUTO ) 
		private int transactionId;
		private String transactionType;
		@JsonFormat(pattern="yyyy-mm-dd",shape=Shape.STRING)
		private String transactionDate;
	   
		@ManyToOne(cascade = CascadeType.ALL)
		public Wallet wallet;
		private double amount;
		private String description;
		
		public Transaction() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Transaction(int transactionId, String transactionType, String transactionDate, Wallet wallet,
				double amount, String description) {
			super();
			this.transactionId = transactionId;
			this.transactionType = transactionType;
			this.transactionDate = transactionDate;
			this.wallet = wallet;
			this.amount = amount;
			this.description = description;
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

		public String getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(String transactionDate) {
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

		@Override
		public String toString() {
			return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
					+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + ", amount=" + amount
					+ ", description=" + description + "]";
		}
		
		
}
