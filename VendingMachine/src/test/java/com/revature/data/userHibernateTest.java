//package com.revature.data;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.beans.user.User;
//import com.revature.beans.vendingmachine.VendingMachine;
//
//public class userHibernateTest {
//	static UserHibernate uh = new UserHibernate();
//	static int id;
//	static int num;
//	static int bc;
//	//static String uname=
//	@Before
//	public void setNum() {
//		num=uh.getAll().size();
//	}
//	@BeforeClass
//	static public void setup() {
//		bc=uh.getAll().size();
//		User u5 = new User();
//		u5.setFirstName("Jordy");
//		u5.setLastName("Then");
//		u5.setEmail("fordythen@gmail.com");
//		u5.setPassword("pass");
//		
//		u5.setUsername("usertest"+bc);
//		u5.setBalance(1000.00);
//		u5.setVendingMachine(null);
//		u5.setRatingHistory(null);
//		id=uh.add(u5);
//	}
//	@Test
//	public void getByUsernameAndPasswordTest() {
//		User u = uh.getByUsernameAndPassword("usertest"+bc, "pass");
//		System.out.println("user is " + u);
//		assertTrue(u.getEmail().contains("fordythen@gmail.com"));
//	}
////	ADDING works as of Friday May 29 :)
//	@Test
//	public void addTest() {
//		User u = new User();
//		u.setFirstName("Jordy");
//		u.setLastName("Then");
//		u.setEmail("jordythen@gmail.com");
//		u.setPassword("pass");
//		u.setUsername("jordythen"+num);
//		u.setBalance(1000.00);
//		VendingMachine vm = new VendingMachine();
//		u.setVendingMachine(vm);
//		u.setRatingHistory(null);
//		u.setId(uh.add(u));
//		System.out.println("THIS IS THE ID OF CREATED PERSON: "+u.getId());
//
//		User u2 = uh.getByUsernameAndPassword("jordythen"+num, "pass");
//		System.out.println("user is " + u2);
//		assertTrue(u2.getEmail().contains("jordythen@gmail.com"));
//		assertTrue(u2.getVendingMachine()!= null);
//	}
//	
//	@Test
//	public void getByIdTest() {
//		User u = uh.getById(id);
//		System.out.println("user is " + u);
//		assertTrue(u.getEmail().contains("fordythen@gmail.com"));
//	}
//	@Test
//	public void getByAllTest() {
//		List<User> u = uh.getAll();
//		System.out.println(u);
//		assertTrue(u.size()>=1);
//	}
//	
//
//	
//
//}
