package com.universal_pay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class BeneficiaryDetails {
	
//	private Integer beneficiaryId;
	@Id
	private String mobileNumber;
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Wallet wallet;
	
	public BeneficiaryDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public BeneficiaryDetails(String mobileNumber, String name, int beneficiaryId, Wallet wallet) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
//		this.beneficiaryId = beneficiaryId;
		this.wallet = wallet;
	}

	
	
//	public int getBeneficiaryId() {
//		return beneficiaryId;
//	}
//
//	public void setBeneficiaryId(int beneficiaryId) {
//		this.beneficiaryId = beneficiaryId;
//	}

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
		return "BeneficiaryDetails [mobileNumber=" + mobileNumber + ", name=" + name + ", beneficiaryId=" + "]";
	}
	
	
}
