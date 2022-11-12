package com.universal_pay.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentUserSession {
	
	@Id
	private String userMobileNo;
	private String uuId;
	private LocalDateTime localDateTime;
	
	public CurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentUserSession(String userMobileNo, String uuId, LocalDateTime localDateTime) {
		super();
		this.userMobileNo = userMobileNo;
		this.uuId = uuId;
		this.localDateTime = localDateTime;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [userMobileNo=" + userMobileNo + ", uuId=" + uuId + ", localDateTime="
				+ localDateTime + "]";
	}
	
	

}
