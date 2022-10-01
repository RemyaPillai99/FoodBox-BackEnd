package com.store.foodJets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.store.foodJets.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findByEmailIdAndPassword(String emailId, String password);
	
	@Query("SELECT u FROM User u WHERE u.emailId LIKE %?1%"
			+" OR u.firstName LIKE %?1%"
			+" OR u.lastName LIKE %?1%"
			+" OR u.phoneNum LIKE %?1%")
	public List<User> searchUser(String keyword);
	
	

}
