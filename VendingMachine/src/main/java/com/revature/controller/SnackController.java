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
import com.revature.services.UserService;
import com.revature.services.VendingMachineService;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping(path="/snack")
public class SnackController {
	public static Logger log = Logger.getLogger(SnackController.class);
	private SnackService sserv;
	private UserService userv;
	private VendingMachineService vmserv;
	@Autowired
	public SnackController(SnackService s, UserService u) {
		sserv=s;
		userv=u;
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
	public ResponseEntity<Snack> addSnack(@RequestBody Snack s, HttpSession session ){
		s.setId(sserv.add(s));
		updateSessionUser(session);
		return ResponseEntity.ok(s);
	}
	
	@PostMapping(path="/{id}")
	public ResponseEntity<VendingMachine> addSnackToVM(@RequestBody Snack s, @PathVariable("id") Integer id, HttpSession session ){
		s.setId(sserv.add(s));
		VendingMachine vm=vmserv.getById(id);
		List<Snack> slist=vm.getSnacks();
		slist.add(s);
		vm.setSnacks(slist);
		vmserv.update(vm);
		updateSessionUser(session);
		return ResponseEntity.ok(vm);
	}
	
	@PutMapping
	public ResponseEntity<Snack> updateSnack(@RequestBody Snack s, HttpSession session ){
		sserv.update(s);
		updateSessionUser(session);
		return ResponseEntity.ok(sserv.getById(s.getId()));
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteSnack(@PathVariable("id") Integer id, HttpSession session ){
		Snack s=sserv.getById(id);
		sserv.delete(s);
		updateSessionUser(session);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/buywithmoney")
	public ResponseEntity<Void> buySnackWithMoney(@RequestBody Snack s, HttpSession session){
		User u=(User) session.getAttribute("user");
		log.info("Received purchase request...");
		VendingMachine buyer=u.getVendingMachine();
		if (buyer==null|| s==null) {
			return ResponseEntity.status(400).build();
		}else {
			sserv.buySnackFromVendingMachine(s, buyer, u);
			//User u2=userv.getById(u.getId());
//			u.setBalance(u.getBalance()-s.getCost());
//			userv.merge(u);
			updateSessionUser(session);
			return ResponseEntity.ok().build();
		}
		
	}
	public void updateSessionUser(HttpSession session) {
		User u=(User) session.getAttribute("user");
		User u2=userv.getById(u.getId());
		session.setAttribute("user", u2);
	}
	
}
