package com.revature.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.beans.user.User;

public class userHibernateTest {
	static UserHibernate uh = new UserHibernate();
	
	@Test
	public void test() {
		User u = uh.getByUsernameAndPassword("jordythen", "pass");
		System.out.println("user is " + u);
		assertTrue(u.getEmail().contains("jordythen@gmail.com"));
	}
	@Test
	public void testAdd() {
		User u = new User();
		u.setFirstName("Jordy");
		u.setLastName("Then");
		u.setEmail("jordythen@gmail.com");
		u.setPassword("pass");
		u.setUsername("jordythen");
		u.setBalance(1000.00);
		u.setVendingMachine(null);
		u.setRatingHistory(null);
		uh.add(u);
		System.out.println(u.getId());
	}
	
	@Test
	public void getByIdTest() {
		User u = uh.getById(1);
		System.out.println("user is " + u);
		assertTrue(u.getEmail().contains("cmonster@email.com"));
	}
	@Test
	public void getByAllTest() {
		List<User> u = uh.getAll();
		System.out.println(u);
		//assertTrue(u.getEmail().contains("cmonster@email.com"));
	}
	
//	@Test
//	public void getByIdTest() {
//		List<User> u = uh.getAll();
//		System.out.println(u);
//		//assertTrue(u.getEmail().contains("cmonster@email.com"));
//	}
	

}
