package com.universal_pay.service;

import com.universal_pay.model.BillPayment;

public interface IBillPaymentService {

	public BillPayment addBillPayment(BillPayment payment) throws Exception;
	public BillPayment viewBillPayment(int id) throws Exception;
}
