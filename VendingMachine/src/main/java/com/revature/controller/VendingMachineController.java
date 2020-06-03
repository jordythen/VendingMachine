package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.snack.Type;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.services.VendingMachineService;

@RestController
@CrossOrigin(origins ="http://localhost:4200", allowCredentials = "true")
@RequestMapping(path="/vendingMachine")
public class VendingMachineController {
	private VendingMachineService vendingService; 
	public Logger logger = Logger.getLogger(VendingMachineController.class);
	

	@Autowired
	public VendingMachineController(VendingMachineService vms) {
		vendingService = vms;
	}
	
	@GetMapping
	public ResponseEntity<List<VendingMachine>> getAll(){
		List<VendingMachine> allVendingMachines = vendingService.getAll();
		
		return ResponseEntity.ok(allVendingMachines);
		
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<VendingMachine> getVendingMachineById(@PathVariable("id") int id){
		VendingMachine vm = vendingService.getById(id);
		
		/* Commented out by Michael: I'm now checking for a null object on front end to 
		   show a message that there were no matches, instead of throwing this error. */
		//if(vm == null) {
		//	return ResponseEntity.notFound().build();
		//}
		
		return ResponseEntity.ok(vm);
	}
	
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<List<VendingMachine>> getVendingMachineByName(@PathVariable("name") String name){
		
		List<VendingMachine> vm = vendingService.getByName(name);
		
		return ResponseEntity.ok(vm);
		
	}
	
	@GetMapping(path = "/type/{type}")
	public ResponseEntity<List<VendingMachine>> getVendingMachineByType(@PathVariable("type") int type){
		
		List<VendingMachine> vm = vendingService.getByType(type);
		
		return ResponseEntity.ok(vm);
	}
	
	@GetMapping(path = "/popularity/highest")
	public ResponseEntity<List<VendingMachine>> getHighestRatedMachine(){
		
		List<VendingMachine> vm = vendingService.getByHighestPopularity();
		
		return ResponseEntity.ok(vm);
	}
	
	@GetMapping(path = "/popularity/lowest")
	public ResponseEntity<List<VendingMachine>> getLowestRatedMachine(){
		
		List<VendingMachine> vm = vendingService.getByLowestPopularity();
		
		return ResponseEntity.ok(vm);
	}
	
	@PutMapping(path = "/update")
	public void updateMachine(VendingMachine vm){
		vendingService.update(vm);
	}
}
