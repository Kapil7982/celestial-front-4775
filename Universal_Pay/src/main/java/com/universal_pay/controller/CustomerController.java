package com.universal_pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.universal_pay.exception.CustomerException;
import com.universal_pay.model.Customer;
import com.universal_pay.repo.CustomerRepo;
import com.universal_pay.service.CustomerService;
import com.universal_pay.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer customer) throws CustomerException {
		
		
		cService.createCustomer(customer);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		
		
	
		
		
		
	}

}
