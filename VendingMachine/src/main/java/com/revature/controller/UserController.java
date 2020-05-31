package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.user.User;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping(path="/login")
public class UserController {
	public static Logger log = Logger.getLogger(UserController.class);
	private UserService uServ;
	
	@Autowired
	public UserController(UserService u) {
		uServ = u;
	}
	
	@GetMapping 
	public ResponseEntity<User> checkIfLoggedIn(HttpSession session){
		log.info("Checking to see if user session is occupied");
		User u = (User) session.getAttribute("user");
		if(u != null) {
			log.trace("user already logged in");
		}else {
			log.trace("user is not logged in");
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(u);
	}
	
	@PostMapping
	public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("pass") String password, HttpSession session){
		User u = (User) session.getAttribute("user");
		if(u != null) {
			//already logged in
			log.trace("user already logged in");
		}else {
			log.trace("User is not in session, attempting to log in with username " + username + " and password " + password);
			u = uServ.getByUsernameAndPassword(username, password);
			if (u != null) {
				log.info("User was found!");
				session.setAttribute("user", u);
			}else {
				log.info("No user found with username and password");
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.ok(u);
	}
	
	@DeleteMapping
	public ResponseEntity<User> logout(HttpSession session){
		session.invalidate();
		log.info("User has been logged out");
		return ResponseEntity.ok().build();
	}

}
