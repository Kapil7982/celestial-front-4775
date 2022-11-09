package com.universal_pay.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeneficiaryDetails {
	@Id
	String mobileNumber;
	String name;
	
	public BeneficiaryDetails() {
		// TODO Auto-generated constructor stub
	}

	public BeneficiaryDetails(String mobileNumber, String name) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
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

	@Override
	public String toString() {
		return "BeneficiaryDetails [mobileNumber=" + mobileNumber + ", name=" + name + "]";
	}
	
}
