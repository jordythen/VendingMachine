package com.revature.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.user.User;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.services.UserService;

public class UserServiceTest {

	static UserHibernate uh = new UserHibernate();
	static VendingMachineHibernate vh = new VendingMachineHibernate();

	static UserService us = new UserService(uh,vh);
	static int num;

	@Before
	public void setNum() {
		num=uh.getAll().size();
	}
	@Test
	public void test() {
		User u = new User();
		User u2 = new User();
		u.setFirstName("Michael");
		u.setLastName("Mead");
		u.setEmail("michaelmead@gmail.com");
		u.setPassword("pass");
		u.setUsername("michaelmead"+num);
		u.setBalance(1000.00);
		u.setRatingHistory(null);
		u2=us.registerAccount(u);
		
		assertTrue(u2.getVendingMachine() != null);

	}

}
