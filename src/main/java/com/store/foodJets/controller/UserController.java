package com.store.foodJets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.foodJets.model.User;
import com.store.foodJets.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/users") // Request body --> json data
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser= userService.saveUser(user);
		
		if(saveUser!=null)
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	// fetchAll users
	// Http method : get
	// uri : /users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.fetchUserList();

	}
	
	
	@GetMapping("users/{emailId}")
	public ResponseEntity<User>getUserById (@PathVariable String emailId){
		User user= userService.getUser(emailId);
		
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
	
	
	// update

		@PutMapping(value = "/users/{emailId}")
		public void updateUser(@PathVariable String emailId, @RequestBody User userDataInput) {
			userService.updateUser(userDataInput);
			
			
		}
	
		
		//delete
		
		@DeleteMapping("/users/{emailId}")
		public void deleteUser(@PathVariable String emailId){
			  userService.deleteByEmailId(emailId);
				/*
				 * if(result) return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
				 * else return new ResponseEntity<String>("NO user Found",
				 * HttpStatus.NOT_FOUND);
				 */
		}
		
		//search by keyword 

		@GetMapping("/users/search/{keyword}")
		public List<User> searchCustomer(@PathVariable String keyword){
			return userService.searchUserbyKeyword(keyword);
		}
		
	 

}
