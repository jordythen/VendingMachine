package com.revature.beans.vendingmachine;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.revature.beans.snack.Snack;
import com.revature.beans.user.Review;

public class VendingMachine {
	
	private Integer id;
	private String name;
	private String description;
	private String theme;
	
	//These will be stored in HEX
	private String mainColor;
	private String secondaryColor;
	
	private Set<Review> ratings;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="vendingmachine_snack", joinColumns=@JoinColumn(name="vendingmachine_id"),
											inverseJoinColumns=@JoinColumn(name="snack_id"))
	private Set<Snack> snacks;
	
	private Set<Snack> hiddenSnacks;
	
	
	
}
