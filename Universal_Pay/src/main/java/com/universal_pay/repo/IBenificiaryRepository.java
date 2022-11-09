package com.universal_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universal_pay.model.BeneficiaryDetails;

public interface IBenificiaryRepository extends JpaRepository<BeneficiaryDetails, String>{

}
