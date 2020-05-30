package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.user.Order;

public class OrderHibernateTest {
	static OrderHibernate oh = new OrderHibernate();

	/*
	 * These tests are given very specific expected values. Most notably testGetAll
	 * That test will FAIL once another order is added. These tests are written for
	 * functionality testing on the fly...I'll go back a little later this weekend, and
	 * re-write them so that they scale appropriately.
	 */
	@Test
	public void testGetById() {
		Order order = oh.getById(1);
		double expected = 1.5; 
		double actual = order.getOrderTotal();
		System.out.println("Method rettrieved: " + order);
		assertTrue(expected == actual);
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
	}
	
	@Test
	public void testGetAll() {
		List<Order> allOrders = oh.getAll();
		
		int expected = 2; 
		int actual = allOrders.size();
		System.out.println("Method retrieved: " + allOrders);
		assertTrue(expected == actual);
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
	}

}
