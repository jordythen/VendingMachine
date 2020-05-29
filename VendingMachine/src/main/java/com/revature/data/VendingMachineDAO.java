package com.revature.data;

import java.util.List;

import com.revature.beans.snack.Type;
import com.revature.beans.vendingmachine.VendingMachine;

public interface VendingMachineDAO extends GenericDAO<VendingMachine> {
	
	//5.5 User can search for other people's vending machine by name
	public VendingMachine getByName(VendingMachine vm);
	
	//5.7 User can search for other people's vending machine ordered by popularity(highest rating first)
	public List<VendingMachine> getByPopularityHighest();
	
	//5.8 User can search for other people's vending machine ordered by popularity(lowest rating first)
	public List<VendingMachine> getByPopularityLowest();
	
	//5.9 User can search for other people's vending machine by type
	public List<VendingMachine> getByType(Type t);
}
