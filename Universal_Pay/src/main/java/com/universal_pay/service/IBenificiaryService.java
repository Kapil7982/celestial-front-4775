package com.universal_pay.service;

import java.util.List;

import com.universal_pay.model.BeneficiaryDetails;
import com.universal_pay.model.Customer;



public interface IBenificiaryService {
	public BeneficiaryDetails addBenificiary(BeneficiaryDetails bd);
	public BeneficiaryDetails deleteBenificiary(BeneficiaryDetails bd);
	public BeneficiaryDetails viewBenificiary(String mobNo);
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);
}
