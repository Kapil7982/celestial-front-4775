package com.universal_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universal_pay.model.BankAccount;

@Repository
public interface AccountRepo extends JpaRepository<BankAccount, Integer> {

}
