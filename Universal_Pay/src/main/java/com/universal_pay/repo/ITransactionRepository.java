package com.universal_pay.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universal_pay.model.BillPayment;
import com.universal_pay.model.Transaction;
import com.universal_pay.model.Wallet;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction,Integer>{
	
}
