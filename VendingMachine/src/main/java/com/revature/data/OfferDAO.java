package com.revature.data;

import java.util.List;

import com.revature.beans.user.Offer;

public interface OfferDAO extends GenericDAO<Offer> {
	
	public List<Offer> getAllOffersByVendingID(Integer id);
	public void deleteOfferById(int id);
	
	/*
	 * we dont have a column for this in Offer table. We have the Table
	 * "User Offer" however it is not currently a mapped bean
	 */
	public List<Offer> getAllOffersByUserID();

}
