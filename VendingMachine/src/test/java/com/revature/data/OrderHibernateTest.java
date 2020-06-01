package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.user.Order;

public class OrderHibernateTest {
	static OrderHibernate oh = new OrderHibernate();
	//static int orderID;

	/*
	 * These tests are given very specific expected values. Most notably testGetAll
	 * That test will FAIL once another order is added. These tests are written for
	 * functionality testing on the fly...I'll go back a little later this weekend, and
	 * re-write them so that they scale appropriately.
	 */
	
	public Order createOrder() {
		Order order;
		int orderID = 1;
		
		Order existingOrder = oh.getById(orderID);
		
		while (existingOrder != null) {
			orderID = orderID ++;
			
			existingOrder = oh.getById(orderID);
			
		
			
			if (existingOrder == null) {
				order = new Order();
				
				order.setId(orderID);
				order.setOrderTotal(3.50);
				order.setTax(3.00);	
				
				existingOrder = order;
				
				
			}
					
		}
		return existingOrder;
		
	}
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
	
	
	// TEST NOT WORKING, FINISH THIS LATER
	@Test
	public void testAddOrder() {
		
		Order order = new Order();
		
		
		order.setOrderTotal(3.50);
		order.setTax(3.00);
		order.setId(oh.add(order));
		
		Order addedOrder = oh.getById(3);
		
		assertTrue(addedOrder != null);
		System.out.println("added Order = " + addedOrder);
		
		
		
		
//		Integer expectedOrder = oh.add(createOrder());
//		
//		List<Order> actual = oh.getAll();
//		
//		assertTrue(actual.contains(expectedOrder));
		
		
		
	}

}
