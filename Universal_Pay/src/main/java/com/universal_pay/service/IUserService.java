package com.universal_pay.service;

import com.universal_pay.model.Customer;

public interface IUserService {

	public String validateLogin(String mobileNumber,String password) throws Exception;
}
