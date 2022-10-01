package com.store.foodJets.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.foodJets.model.User;
import com.store.foodJets.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> verifyLogin(@RequestBody User user){
		
		User userDB = userService.getUser(user.getEmailId(),user.getPassword());
		
		
		if(userDB!=null)
		{
			
			return new ResponseEntity<User>(userDB,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@PostMapping(path = "/register") // Request body --> json data
	public ResponseEntity<User> register(@RequestBody User user) {
		
	
				System.out.println(user.getFirstName());
				// response header : location
				// status code :201
				User SaveUser = userService.saveUser(user);
//			
		
		if(SaveUser!=null)
			return new ResponseEntity<User>(SaveUser,HttpStatus.CREATED);
		else
			return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		

	}
	
	
	
	

}
