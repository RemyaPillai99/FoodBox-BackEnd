package com.store.foodJets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.foodJets.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	

	Admin findByEmailIdAndPassword(String emailId, String password);
}
