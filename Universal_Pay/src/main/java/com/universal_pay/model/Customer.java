package com.universal_pay.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@Size(min=10,max=12)
	private String mobileNumber;
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;
	@NotNull
	@NotBlank
	@Size(min=4, max=10)
	private String password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	
	

}
