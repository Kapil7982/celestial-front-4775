package com.universal_pay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universal_pay.model.CurrentUserSession;

public interface SessionRepo extends JpaRepository<CurrentUserSession, String>{
	
	public CurrentUserSession findByuuId(String uuId);

}
