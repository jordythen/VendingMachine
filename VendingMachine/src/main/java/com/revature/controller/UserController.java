package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.user.User;
import com.revature.services.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	private UserService uServ;
	
	@Autowired
	public UserController(UserService u) {
		uServ = u;
	}
	
	@PostMapping
	public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("pass") String password){
		
		return null;
		
	}
	

}
