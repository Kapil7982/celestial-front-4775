package com.universal_pay.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal_pay.exception.BenificiaryException;
import com.universal_pay.model.BeneficiaryDetails;
import com.universal_pay.model.Customer;
import com.universal_pay.model.Wallet;
import com.universal_pay.repo.IBenificiaryRepository;
import com.universal_pay.repo.WalletRepository;
@Service
public class IBenificiaryServiceImpl implements IBenificiaryService{
	@Autowired
	WalletRepository walletRepo;
	@Autowired
	IBenificiaryRepository ibRepo;

	@Override
	public BeneficiaryDetails addBenificiary(BeneficiaryDetails bd) throws BenificiaryException{
		Wallet wallet = bd.getWallet();
		List<BeneficiaryDetails> list= wallet.getBenificiaryDetails();
		if(list.contains(bd)) {
			throw new BenificiaryException("Benificiary with this mobile number already exist");
		}else {
			list.add(bd);
			wallet.setBenificiaryDetails(list);
			walletRepo.save(wallet);
			return bd;
		}
		
	}

	@Override
	public BeneficiaryDetails deleteBenificiary(BeneficiaryDetails bd) throws BenificiaryException {
		Wallet wallet = bd.getWallet();
		List<BeneficiaryDetails> list= wallet.getBenificiaryDetails();
		List<BeneficiaryDetails> newList= new ArrayList<>();
		if(list.contains(bd)) {
			for(BeneficiaryDetails benificiaryDetails : list) {
				if(bd.getMobileNumber().equals(benificiaryDetails.getMobileNumber())) {
					continue;
				}else {
					newList.add(benificiaryDetails);
				}
			}
			wallet.setBenificiaryDetails(newList);
			walletRepo.save(wallet);
			return bd;
		}else {
			throw new BenificiaryException("Benificiary with this mobile number do not exist");
		}
	}

	@Override
	public BeneficiaryDetails viewBenificiary(String  mob) throws BenificiaryException{
		//To make this method working we need to make mobileNumber as ID in our BenificiaryDetails class then we will
		//get our BenificiaryDetails object
		Optional<BeneficiaryDetails> opt= ibRepo.findById(mob);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new BenificiaryException("No benificial is added with this mobile number");
		}
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) {
		Wallet wallet= customer.getWallet();
		List<BeneficiaryDetails> beneficiaryDetails= wallet.getBenificiaryDetails();
		return beneficiaryDetails;
	}

}
