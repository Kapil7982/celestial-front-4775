package com.universal_pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universal_pay.model.BillPayment;
import com.universal_pay.repo.IBillPaymentRepository;

@Service("IBillPaymentService")
public class IBillPaymentServiceImpl implements IBillPaymentService {
	
	@Autowired
	IBillPaymentRepository iBillPaymentRepository;

	@Override
	public BillPayment addBillPayment(BillPayment payment) throws Exception {
		iBillPaymentRepository.saveAndFlush(payment);
		return payment;
	}

	@Override
	public BillPayment viewBillPayment(int id) throws Exception {
		BillPayment  bean = null;
		try {
			bean = iBillPaymentRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new Exception("Bill Payment details not found!");
		}
		return bean;
	}

}
