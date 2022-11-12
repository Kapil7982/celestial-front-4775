package com.universal_pay.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.LoginException;
import com.universal_pay.model.CurrentUserSession;
import com.universal_pay.model.Customer;
import com.universal_pay.model.LoginDTO;
import com.universal_pay.repo.CustomerRepo;
import com.universal_pay.repo.SessionRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private CustomerRepo cRepo;
	@Autowired
	private SessionRepo sRepo;

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		String str = null;
		Customer existingCustomer = cRepo.findBymobileNumber(dto.getMobileNumber());
		
		if(existingCustomer == null) {
			throw new LoginException("Enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt = sRepo.findById(existingCustomer.getMobileNumber());
		
		if(validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already logged in with this mobile number");
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			
			CurrentUserSession cus = new CurrentUserSession(existingCustomer.getMobileNumber(),key,LocalDateTime.now());
			
			sRepo.save(cus);
			str = cus.toString();
			
			return str;
		}
		
		return str;
	}

	@Override
	public String logoutFromAccount(String key) throws LoginException {
		
		CurrentUserSession cus = sRepo.findByuuId(key);
		
		if(cus == null) {
			throw new LoginException("User not logged in with this number");
		}
		sRepo.delete(cus);
		
		return "Logged out !!!";
	}

}
