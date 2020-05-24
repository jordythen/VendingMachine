package com.revature.beans.user;

import java.time.LocalDateTime;

import com.revature.beans.vendingmachine.VendingMachine;

public class Order {
	
	private Integer id;
	private User orderMadeBy;
	private VendingMachine orderMadeTo;
	private Money tax;
	private Money orderTotal;
	private LocalDateTime orderTime;
	
}
