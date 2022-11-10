package com.universal_pay.service;

import java.util.List;

import javax.validation.Valid;

import com.universal_pay.exception.BenificiaryException;
import com.universal_pay.model.BeneficiaryDetails;
import com.universal_pay.model.Customer;



public interface IBenificiaryService {
	public BeneficiaryDetails addBenificiary(BeneficiaryDetails bd)throws BenificiaryException;
	public BeneficiaryDetails deleteBenificiary(BeneficiaryDetails bd) throws BenificiaryException;
	public BeneficiaryDetails viewBenificiary (Integer mob) throws BenificiaryException;
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);
}
