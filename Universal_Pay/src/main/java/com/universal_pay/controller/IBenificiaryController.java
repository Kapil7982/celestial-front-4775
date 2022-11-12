package com.universal_pay.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universal_pay.exception.BenificiaryException;
import com.universal_pay.model.BeneficiaryDetails;
import com.universal_pay.model.Customer;
import com.universal_pay.service.IBenificiaryService;

import java.util.List;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pwa-payment")
public class IBenificiaryController {
	@Autowired
	private IBenificiaryService ibservice;
	
	@PostMapping("/addBenificiary")
	public ResponseEntity<BeneficiaryDetails> registerBenificiary(@RequestBody BeneficiaryDetails bd) throws BenificiaryException{
		BeneficiaryDetails benificiary= ibservice.addBenificiary(bd);
		return new ResponseEntity<>(benificiary,HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteBenificiary")
	public ResponseEntity<BeneficiaryDetails> deleteBenificiary(@RequestBody BeneficiaryDetails bd)throws BenificiaryException{
		BeneficiaryDetails deleteBenificiary=ibservice.deleteBenificiary(bd);
		return new ResponseEntity<>(deleteBenificiary,HttpStatus.OK);
	}
	@GetMapping("/viewBenificiary/{mob}")
	public ResponseEntity<BeneficiaryDetails> viewBenificiaryById(@Valid @PathVariable("mob")String mob ) throws BenificiaryException{
		BeneficiaryDetails benificiary=ibservice.viewBenificiary(mob);
		return new ResponseEntity<BeneficiaryDetails>(benificiary,HttpStatus.OK);
	}
	@PostMapping("/viewAllBenificiary")
	public ResponseEntity<List<BeneficiaryDetails>> viewAllBenificiaryDetails(@Valid @RequestBody Customer customer){
		List<BeneficiaryDetails> list=ibservice.viewAllBeneficiary(customer);
		return new ResponseEntity<List<BeneficiaryDetails>>(list,HttpStatus.OK);
	}
}
