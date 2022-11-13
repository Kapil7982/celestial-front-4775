package com.universal_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class BeneficiaryDetails {
	

	@Id
//	@Size(min = 8,max = 12)
	private String mobileNumber;
	
	
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
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
