package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.user.Offer;

public class OfferHibernateTest {
	static OfferHibernate offerHiber = new OfferHibernate();

//	@Test
//	public void testGetAllOffersByVendingID() {
//		Integer vendingId = 1;
//		
//		List<Offer> offer = offerHiber.getAllOffersByVendingID(vendingId);
//		
//		int expected = 1;
//		int actual = offer.size();
//		
//		System.out.println("Expected: " + expected + " Actual: " + actual);
//		assertTrue(expected == actual);
//		
//		
//	}
	
	@Test
	public void testGetById() {
		Offer offer = offerHiber.getById(1);
		
		int expected = 1;
		int actual = offer.getId();
		
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
		assertTrue(expected == actual);
	}

}
