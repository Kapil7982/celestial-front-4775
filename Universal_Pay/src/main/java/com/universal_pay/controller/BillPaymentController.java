package com.universal_pay.controller;

import org.springframework.beans.factory.annotation.Autowired;


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
import com.universal_pay.model.BillPayment;
import com.universal_pay.model.Wallet;
import com.universal_pay.service.IBillPaymentService;


@RestController
@RequestMapping("/pwa-payment")
public class BillPaymentController {
	
	@Autowired
	IBillPaymentService iBillPaymentService;
	
	@PostMapping("/addBillPayment")
	public BillPayment addBillPayment(@RequestBody BillPayment payment) throws Exception{
		return iBillPaymentService.addBillPayment(payment);
	}
	
	@GetMapping("/viewBillPayment/{id}")
	public BillPayment viewBillPayment(@PathVariable int id) throws Exception{
		return iBillPaymentService.viewBillPayment(id);
	}

}
