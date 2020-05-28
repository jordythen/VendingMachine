package com.revature.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.user.User;

public class userHibernateTest {
	static UserHibernate uh = new UserHibernate();
	
//	@Test
//	public void test() {
//		User u = uh.getByUsernameAndPassword("cmonster", "c123");
//		System.out.println("user is " + u);
//		assertTrue(u.getEmail().contains("cmonster@email.com"));
//	}
	@Test
	public void getByIdTest() {
		User u = uh.getById(1);
		System.out.println("user is " + u);
		assertTrue(u.getEmail().contains("cmonster@email.com"));
	}
	

}
