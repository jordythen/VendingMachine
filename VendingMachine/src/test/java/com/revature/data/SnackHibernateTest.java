package com.revature.data;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.snack.Snack;
import com.revature.beans.snack.Type;

public class SnackHibernateTest {
	static SnackHibernate sdao=new SnackHibernate();
	static int id;
	static int afterid;
	@BeforeClass
	static public void setup() {
		Snack s=new Snack();
		s.setDescription("iJUnit test case");
		s.setId(sdao.add(s));
		id=s.getId();
		}
	@Test
	public void getByIdTest() {
		Snack s=sdao.getById(id);
		System.out.println(s);
		assertTrue(s.getDescription().contains("iJUnit"));
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
		Set<Type> set=new HashSet<Type>();
		set.add(t);
		set.add(t2);
		s.setTypes(set);
		int i=sdao.add(s);
		
		s=sdao.getById(i);
		System.out.println(s);
		assertTrue(s.getDescription().contains("TypeTest"));
		
	}
	
	@Test
	public void getAllTest() {
		List<Snack> lists=sdao.getAll();
		System.out.println(lists);
		assertTrue(lists.size()>=1);
	}
	
	@Test
	public void updateTest() {
		Snack s=new Snack();
		s.setDescription("iJUnit test case");
		s.setId(sdao.add(s));
		
		s.setDescription("update");
		sdao.update(s);
		assertTrue(sdao.getById(s.getId()).getDescription().contains("update"));
	}
	
	@Test
	public void deleteTest() {
		Snack p=new Snack();
		p.setDescription("iJUnit test case");
		p.setId(sdao.add(p));
		afterid=p.getId();
		sdao.delete(p);
		assertTrue(sdao.getById(p.getId())==null);
		
	}
	
	@AfterClass
	static public void afterTests() {
		System.out.println(afterid);
	}

}
