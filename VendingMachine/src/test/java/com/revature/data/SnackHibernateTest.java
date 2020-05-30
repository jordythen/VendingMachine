package com.revature.data;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.snack.Snack;
import com.revature.beans.snack.Type;

public class SnackHibernateTest {
	static SnackHibernate sdao=new SnackHibernate();
	static int id;
	@BeforeClass
	static public void setup() {
		Snack s=new Snack();
		s.setDescription("JUnit test case");
		id=sdao.add(s);
		}
	@Test
	public void getByIdTest() {
		Snack s=sdao.getById(id);
		System.out.println(s);
		assertTrue(s.getDescription().contains("JUnit test case"));
	}
	
	@Test
	public void addTest() {
		Snack s=new Snack();
		Type t=new Type();
		Type t2=new Type();
		t.setId(1);
		t.setSnacktype("DRIED_FRUIT");
		t2.setId(2);
		t2.setSnacktype("NUTS");
		s.setDescription("TypeTest");
		//s.setId(6);
		Set<Type> set=new HashSet<Type>();
		set.add(t);
		set.add(t2);
		s.setTypes(set);
		int i=sdao.add(s);
		
		s=sdao.getById(i);
		System.out.println(s);
		assertTrue(s.getDescription().contains("TypeTest"));
		
	}

}
