package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.snack.Snack;
import com.revature.beans.user.User;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.services.SnackService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping(path="/snack")
public class SnackController {
	public static Logger log = Logger.getLogger(SnackController.class);
	private SnackService sserv;
	
	@Autowired
	public SnackController(SnackService s) {
		sserv=s;
	}
	
	@GetMapping
	public ResponseEntity<List<Snack>> getAll() {
		List<Snack> slist=sserv.getAll();
		return ResponseEntity.ok(slist);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Snack> getSnackById(@PathVariable("id") Integer id){
		Snack s=sserv.getById(id);
		if (s == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(s);
	}
	
	@PostMapping
	public ResponseEntity<Snack> addSnack(@RequestBody Snack s){
		s.setId(sserv.add(s));
		return ResponseEntity.ok(s);
	}
	
	@PutMapping
	public ResponseEntity<Snack> updateSnack(@RequestBody Snack s){
		sserv.update(s);
		return ResponseEntity.ok(sserv.getById(s.getId()));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteSnack(@PathVariable("id") Integer id){
		Snack s=sserv.getById(id);
		sserv.delete(s);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/buywithmoney")
	public ResponseEntity<Void> buySnackWithMoney(@RequestBody Snack s, HttpSession session){
		User u=(User) session.getAttribute("user");
		VendingMachine buyer=u.getVendingMachine();
		if (buyer==null|| s==null) {
			return ResponseEntity.status(400).build();
		}else {
			sserv.buySnackFromVendingMachine(s, buyer);
			return ResponseEntity.ok().build();
		}
		
	}
	
}
