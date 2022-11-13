package com.universal_pay.model;

public class LoginDTO {
	
	private String mobileNumber;
	private String password;
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LoginDTO(String mobileNumber, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
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
	
	

}
