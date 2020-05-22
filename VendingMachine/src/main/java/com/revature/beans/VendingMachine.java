package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

public class VendingMachine {
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="vendingmachine_snack", joinColumns=@JoinColumn(name="vendingmachine_id"),
											inverseJoinColumns=@JoinColumn(name="snack_id"))
	Set<Snack> snacks;

}
