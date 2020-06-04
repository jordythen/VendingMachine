package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.user.Review;
import com.revature.services.ReviewServiceImpl;

@RestController
@CrossOrigin(origins ="http://localhost:4200", allowCredentials = "true")
@RequestMapping(path="/review")
public class ReviewController {
	public Logger log = Logger.getLogger(VendingMachineController.class);
	private ReviewServiceImpl rserv;
	
	@Autowired
	public ReviewController(ReviewServiceImpl rs) {
		rserv = rs;
	}

	@PostMapping(path="/submit")
	public ResponseEntity<Review> submit(@RequestBody Review r){
		
		System.out.println(r);
		
		log.info("Adding review "+ r);
		r.setId(rserv.add(r));
		return ResponseEntity.ok(r);
	}
	
	@GetMapping(path = "/machine/{id}")
	public ResponseEntity<List<Review>> getReviewsByMachineId(@PathVariable("id") int id){
		log.info("Getting reviews for machine id "+ id);
		List<Review> revList = rserv.getByMachineId(id);
		return ResponseEntity.ok(revList);
	}
	
}
