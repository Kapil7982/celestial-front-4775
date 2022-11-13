package com.universal_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

@Entity
public class BeneficiaryDetails {
	

	@Id
	private String mobileNumber;
	
	
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Wallet wallet;
	
	public BeneficiaryDetails() {
		// TODO Auto-generated constructor stub
	}
	


	public BeneficiaryDetails(String mobileNumber, String name, Wallet wallet) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.wallet = wallet;
	}

	


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	@Override
	public String toString() {
		return "BeneficiaryDetails [mobileNumber=" + mobileNumber + ", name=" + name + ", wallet=" + wallet + "]";
	}

	
	
	
}
