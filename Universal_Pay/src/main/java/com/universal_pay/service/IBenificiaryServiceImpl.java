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
		if(ibRepo.findById(bd.getMobileNumber()).isEmpty()) {
			
			Wallet wallet = bd.getWallet();
			wallet.getBenificiaryDetails().add(bd);
		    return ibRepo.save(bd);
		}else {
				throw new BenificiaryException("Beneficiary already exists");
			}
		
	}

	@Override
	public BeneficiaryDetails deleteBenificiary(BeneficiaryDetails bd) throws BenificiaryException {
		Optional<BeneficiaryDetails> benificiaryDetails= ibRepo.findById(bd.getMobileNumber());
		if(benificiaryDetails.isPresent()) {
			BeneficiaryDetails b= benificiaryDetails.get();
			Wallet w= bd.getWallet();
			List<BeneficiaryDetails> list=w.getBenificiaryDetails();
			list.remove(bd);
			ibRepo.delete(b);
			return b;
		}else {
			throw new BenificiaryException("Benificiary with this mobile number do not exist");
		}
	}

	@Override
	public BeneficiaryDetails viewBenificiary(String  mob) throws BenificiaryException{
		Optional<BeneficiaryDetails> benificiaryDetails= ibRepo.findById(mob);
		if(benificiaryDetails.isPresent()) {
			return benificiaryDetails.get();
		}else {
			throw new BenificiaryException("No benificiary register with this mobile number");
		}
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) {
		Integer id= customer.getWallet().getWalletId();
		Optional<Wallet> opt= walletRepo.findById(id);
		Wallet wallet= opt.get();
		return wallet.getBenificiaryDetails();
	}

}
