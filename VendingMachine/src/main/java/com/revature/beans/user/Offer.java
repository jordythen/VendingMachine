package com.revature.beans.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.revature.beans.snack.Snack;
import com.revature.beans.vendingmachine.VendingMachine;

public class Offer {
	
	private Integer id;
	private User author;
	private VendingMachine vendingMachine;
	private Set<Snack> snacksOfInterest;
	private Set<Snack> snacksToOffer;
	private Status status;
	private LocalDateTime timeOfferWasMAde;
	
	
}
