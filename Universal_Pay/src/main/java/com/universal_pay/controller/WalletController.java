package com.universal_pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universal_pay.model.BankAccount;
import com.universal_pay.model.Customer;
import com.universal_pay.model.Wallet;
import com.universal_pay.service.IAccountService;
import com.universal_pay.service.WalletService;


@RestController
@RequestMapping("/pwa-wallet")
public class WalletController {
	
	@Autowired
	WalletService walletService;
	
	
	@PostMapping("/createAccount")
	public Customer createAccount(@RequestBody BankAccount acc) throws Exception{
		return walletService.createAccount(acc);
	}
	
	@GetMapping("/showBalance/{mobileno}")
	public Customer showBalance (@PathVariable String mobileno) throws Exception{
		return walletService.showBalance(mobileno);
	}
	
	@PutMapping("/fundTransfer/{sourceMobileNo}/{targetMobileNo}/{amount}")	
	public Customer fundTransfer (@PathVariable String sourceMobileNo,@PathVariable String targetMobileNo,@PathVariable  double amount) throws Exception{
		return walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
	}
	
	@PutMapping("/depositAmount/{mobileNo}/{amount}")	
	public Customer depositAmount (@PathVariable String mobileNo,@PathVariable  double amount ) throws Exception{
		return walletService.depositAmount(mobileNo, amount);
	}
	
	
	@GetMapping("/getList")
	public List<Customer> getList() throws Exception{
		return walletService.getList();
	}
	
	@PutMapping("/updateAccount")
	public Customer updateAccount(@RequestBody Customer customer) throws Exception{
		return walletService.updateAccount(customer);
	}
	
	@PutMapping("/addMoney/{amount}")
	public Wallet addMoney(@RequestBody Wallet wallet,@PathVariable  double amount) throws Exception{
		return walletService.addMoney(wallet, amount);
	}


}
