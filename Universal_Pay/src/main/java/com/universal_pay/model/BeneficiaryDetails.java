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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mobileNumber;
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Wallet wallet;
	
	public BeneficiaryDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public BeneficiaryDetails(Integer mobileNumber, String name, int beneficiaryId, Wallet wallet) {
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

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
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
