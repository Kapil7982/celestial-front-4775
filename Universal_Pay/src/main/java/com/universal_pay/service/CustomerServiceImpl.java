package com.universal_pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.CustomerException;
import com.universal_pay.model.CurrentUserSession;
import com.universal_pay.model.Customer;
import com.universal_pay.repo.CustomerRepo;
import com.universal_pay.repo.SessionRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cRepo;
	@Autowired
	private SessionRepo sRepo;
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
		Customer existingCustomer = cRepo.findBymobileNumber(customer.getMobileNumber());
		
		if(existingCustomer != null) {
			throw new CustomerException("Customer already exists with moblie number "+customer.getMobileNumber());
		}
		
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sRepo.findByuuId(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update customer.");
		}
		
		if(customer.getMobileNumber() == loggedInUser.getUserMobileNo()) {
			return cRepo.save(customer);
		}else {
			throw new CustomerException("Invalid customer datails, login first");
		}
	}

}
