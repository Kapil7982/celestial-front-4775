package com.universal_pay.service;

import com.universal_pay.exception.CustomerException;
import com.universal_pay.model.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key)throws CustomerException;

}
