package com.revature.beans.snack;

import java.util.Set;

import com.revature.beans.user.Money;

public class Snack {

	private Integer id;
	private String snackName;
	private String description;
	private Integer numInStock;
	//nullable
	private Money cost;
	//A snack can have multiple types..
	private Set<Type> types;
	
	//These are counted on grams...
	private Integer totalFat;
	private Integer totalCarbs;
	private Integer sodium;
	private Integer cholesterol;
	
}
