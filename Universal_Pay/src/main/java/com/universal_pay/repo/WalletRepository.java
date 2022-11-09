package com.universal_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universal_pay.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{

	
}
