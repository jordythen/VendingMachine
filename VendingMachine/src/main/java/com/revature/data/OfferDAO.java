package com.revature.data;

import java.util.List;

import com.revature.beans.user.Offer;
import com.revature.beans.user.User;

public interface OfferDAO extends GenericDAO<Offer> {
	
	public List<Offer> getAllOffersByVendingID(Integer vendingMachineID);
	public void deleteOfferById(int id);
	
	/*
	 * we dont have a column for this in Offer table. We have the Table
	 * "User Offer" however it is not currently a mapped bean
	 */
	public List<Offer> getAllOffersByUserID(Integer userID);

}
