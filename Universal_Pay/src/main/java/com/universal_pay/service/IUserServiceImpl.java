package com.universal_pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.model.Customer;
import com.universal_pay.repo.IUserRepo;

@Service("IUserService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepo iUserRepo;

	@Override
	public String validateLogin(String mobileNumber, String password) throws Exception {
		Customer bean = null;
		try {
			for(Customer i : iUserRepo.findAll()) {
				if(i.getMobileNumber().equals(mobileNumber)) {
					if(i.getPassword().equals(password)) {
						return "Authentication Successfull";
					}
					return "User details not found! Invalid details";
				}
			}
		}
		catch(Exception e) {
			throw new Exception("User details not found! Invalid details");
		}
		return "Authentication Successfull";
	}

}
