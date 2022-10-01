package com.store.foodJets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.foodJets.model.User;
import com.store.foodJets.repository.UserRepository;

@Service(value = "userService")//service interface  first letter is small
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
		
	}

	@Override
	public User getUser(String emailId) {
		return userRepository.findById(emailId).get();
	}

	@Override
	public void deleteByEmailId(String emailId) {
		
		userRepository.deleteById(emailId);
		
	}

	@Override
	public User getUser(String emailId, String password) {
		
		return userRepository.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public void updateUser(User user) {
		if(userRepository.findById(user.getEmailId()).get() != null)
			
			   userRepository.save(user);
		
	}

	@Override
	public List<User> fetchUserList() {
		
		return (List<User>) userRepository.findAll();
		
	}

	@Override
	public List<User> searchUserbyKeyword(String keyword) {
		
		return userRepository.searchUser(keyword);
	}

	
	
}
