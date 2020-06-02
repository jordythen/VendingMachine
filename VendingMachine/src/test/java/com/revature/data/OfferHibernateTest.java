package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.user.Offer;

public class OfferHibernateTest {
	Logger loggerForTests = Logger.getLogger(OfferHibernateTest.class);
	static OfferHibernate offerHiber = new OfferHibernate();

	@Test
	public void testGetAllOffersByVendingID() {
		
		List<Offer> numberOfOffers = offerHiber.getAllOffersByVendingID(1);
		int expected = 4;
		int actual = numberOfOffers.size();
		
		assertTrue(actual == expected);
		
		
	}
	
	@Test
	public void testGetById() {
		Offer offer = offerHiber.getById(1);
		loggerForTests.trace("Offer id = " + offer);
		
		int expected = 1;
		int actual = offer.getId();
		loggerForTests.trace("Expected: " + expected + " " + "Actual: " + actual);
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
		assertTrue(expected == actual);
	}
	
	//This works, but we dont want it adding everytime we run tests :p
//	@Test
//	public void testAdd() {
//		
//		Offer offer = new Offer();
//		
//		offer.setId(5);
//		offer.setTimeOfferWasMade("9:49");
//		offerHiber.addOffer(offer);
//		
//		assertTrue(offerHiber.getById(5) != null);
//	}
	
	@Test
	public void testGetOfferByUserID() {
		
		
		List<Offer> numberOfOffers = offerHiber.getAllOffersByUserID(1);
		int expected = 3;
		int actual = numberOfOffers.size();
		
		assertTrue(actual == expected);
		
	}
	
//	@Test
//	@After
//	public void testDelete() {
//		
//		Offer offer = offerHiber.getById(2);
//		
//		offerHiber.delete(offer);
//
//		List<Offer> offerList = offerHiber.getAll();
//		
//		int expected = 0;
//		int actual = offerList.size();
//		
//		assertTrue(actual > expected);
//		
//	}

}


