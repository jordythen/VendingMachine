package com.revature.beans.user;

import java.time.LocalDateTime;

import com.revature.beans.vendingmachine.VendingMachine;

public class Review {
	
	private Integer id;
	private User author;
	private VendingMachine targetVendingMachine;
	
	//One star to five stars!!!!
	private Integer starRating;
	private String comments;
	private LocalDateTime reviewTime;
	
}
