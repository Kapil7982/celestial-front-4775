package com.universal_pay.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universal_pay.model.Customer;
import com.universal_pay.model.Transaction;

@Repository
public interface IUserRepo  extends JpaRepository<Customer,String>{

	public Customer findBymobileNumber(String mobileNo) ;
}
