package com.universal_pay.service;

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
	 IBenificiaryRepository ibRepo;
	@Autowired
	 WalletRepository wrepo;
	@Override
	public BeneficiaryDetails addBenificiary(BeneficiaryDetails bd) throws BenificiaryException{
		boolean flag=ibRepo.existsById(bd.getMobileNumber());
		if(flag) {
			throw new BenificiaryException("Benificiary id : "+bd.getMobileNumber()+" alrady present");
		}else {
			BeneficiaryDetails band= new BeneficiaryDetails();
			band.setMobileNumber(bd.getMobileNumber());
			band.setName(bd.getName());
			Optional<Wallet> w = wrepo.findById(bd.getWallet().getWalledId());
			if(!w.isPresent()) {
				throw new BenificiaryException("wallet with id not found");
			}else {
				band.setWallet(w.get());
				ibRepo.save(band);
				return band;
			}
		}
	}

	@Override
	public BeneficiaryDetails deleteBenificiary(BeneficiaryDetails bd) throws BenificiaryException {
		if(!ibRepo.existsById(bd.getMobileNumber())) {
			throw new BenificiaryException("Benificiary with id "+bd +" is not present");
		}else {
			Optional<BeneficiaryDetails> band1=ibRepo.findById(bd.getMobileNumber());
			ibRepo.deleteById(bd.getMobileNumber());
			return bd;
		}

	}

	@Override
	public BeneficiaryDetails viewBenificiary(Integer  mob) throws BenificiaryException{
		Optional<BeneficiaryDetails> opt= ibRepo.findById(mob);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new BenificiaryException("Benificiary not found");
		}
//		if(!ibRepo.existsById(bd.getBeneficiaryId())) {
//			throw new BenificiaryException("Benificiary with id "+bd +" is not present");
//		}else {
//			return ibRepo.findById(bd.getBeneficiaryId());
//			
//		}
		
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) {
//		Wallet wallet = customer.getWallet();
//		boolean flag= wrepo.existsById(wallet.getWalledId());
//		if(!flag) {
//			throw new BenificiaryException("no Benificiary found with this id"+customer.getWallet().getWalletId());
//		}else {
//			return ibRepo.findByWallet(wallet);
//		}
		return null;
	}

}
