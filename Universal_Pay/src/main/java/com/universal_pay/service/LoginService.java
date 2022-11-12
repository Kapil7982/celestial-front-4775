package com.universal_pay.service;

import com.universal_pay.exception.LoginException;
import com.universal_pay.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;
	public String logoutFromAccount(String key) throws LoginException;

}
