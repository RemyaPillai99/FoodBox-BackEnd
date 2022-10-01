package com.store.foodJets.service;

import java.util.List;

import com.store.foodJets.model.User;



public interface UserService {
	
	public User saveUser(User user);
	public User getUser(String emailId);
	public void deleteByEmailId(String emailId);
	public User getUser(String emailId,String password);
	public void updateUser(User user);
	public List<User> fetchUserList(); 
	public List<User> searchUserbyKeyword(String keyword);
	

}
