package com.universal_pay.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universal_pay.exception.AccountException;
import com.universal_pay.exception.WalletException;
import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Wallet;
import com.universal_pay.service.IAccountService;

@RestController
public class BankAccountController {

	@Autowired
	private IAccountService aService;
	
	@PostMapping("/bankaccount")
	public ResponseEntity<Wallet> registerBankAccountHandler(@Valid @RequestBody BankAccount account) throws AccountException, WalletException {
		
		Wallet wallet = aService.addAccount(account);
		
		return new ResponseEntity<Wallet>(wallet,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/bankaccount/{walletId}/{bankId}")
	public ResponseEntity<Wallet> deleteBankAccountHandler(@PathVariable("walletId") Integer walletId, @PathVariable("bankId") Integer bankId) throws AccountException {
		
		Wallet wallet = aService.removeAccount(walletId,bankId);
		
		return new ResponseEntity<Wallet>(wallet,HttpStatus.OK);
		
	}
	
	@GetMapping("/bankaccounts")
	public ResponseEntity<Set<BankAccount>> viewAllAccountsHandler(@RequestBody Wallet wallet) throws WalletException{
		Set<BankAccount> accounts = aService.viewAllAccounts(wallet);
		return new ResponseEntity<Set<BankAccount>>(accounts,HttpStatus.OK);
	}
	
	
	
	
	
	
}
