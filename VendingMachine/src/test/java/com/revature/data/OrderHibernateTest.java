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
	
	/*--------------------------------------------------------------------------------------
	 * Have you guys seen Mystery Men? There is a Character in the movie who can turn invisible...
	 * but only if you dont look at him.
	 * 
	 * My tests are like that. 
	 * 
	 * All of these tests work...as long as you dont use them... :p 
	 * 
	 * But seriously, these work, however the logic needs fixed. I'll do that throughout the day today (6/2/20)
	 * The reason they dont work is because the expected values are specific to what was in the database when the
	 * tests were written, and the contents of the database have changed, therefore the expected values will need to 
	 * reflect what is there....so the methods work, but the tests will fail. 
	 * As I said, I'll change that so that the expected values are not dependent on specific pieces of data being present
	 * in the DB
	 *
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
		double expected = 1; 
		double actual = order.getId();
		System.out.println("Method rettrieved: " + order);
		assertTrue(expected == actual);
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
	}
	
	@Test
	public void testGetAll() {
		List<Order> allOrders = oh.getAll();
		
		int expected = 0; 
		int actual = allOrders.size();
		System.out.println("Method retrieved: " + allOrders);
		assertTrue(actual > expected);
		System.out.println("Expected: " + expected + " " + "Actual: " + actual);
	}
	
	
	// make sure to comment this out or adjust its values accordingly
	// if you're testing the other tests, Otherwise it will be adding a user
	// everytime you run the tests, and cause fails. 
	
	@Test
	public void testAddOrder() {
		
		Order order = new Order();
		
		order.setId(1);
		order.setOrderTime("8:21am");
		order.setOrderTotal(1.50);
		order.setTax(3.00);
		
		oh.addOrder(order);
		
		List<Order> allOrders = oh.getAll();
		
		int expected = 0;
		int actual = allOrders.size();
		
		assertTrue(actual > expected);
		
		
	}

}
