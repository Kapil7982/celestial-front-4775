package com.universal_pay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universal_pay.exception.AccountException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;
import com.universal_pay.service.IAccountService;

@RestController
public class BankAccountController {

	@Autowired
	private IAccountService aService;
	
	@PostMapping("/bankaccount")
	public ResponseEntity<Wallet> registerBankAccountHandler(@Valid @RequestBody BankAccount account) throws AccountException {
		
		Wallet wallet = aService.addAccount(account);
		
		return new ResponseEntity<Wallet>(wallet,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/bankaccount")
	public ResponseEntity<Wallet> deleteBankAccountHandler(@Valid @RequestBody BankAccount account) throws AccountException {
		
		Wallet wallet = aService.removeAccount(account);
		
		return new ResponseEntity<Wallet>(wallet,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
