package com.revature.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.beans.snack.Snack;
import com.revature.beans.snack.Type;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.services.VendingMachineService;

public class VendingMachineHibernateTest {
	static VendingMachineHibernate vmh = new VendingMachineHibernate();
	static VendingMachineService vms = new VendingMachineService(vmh);
	static SnackHibernate sdao=new SnackHibernate();
//	@Test
//	public void getByNameTest() {
//		//TODO this test only works if we give it a name that we know exists
//		String nameToTest = "Monster Cookie Machine";
//		List<VendingMachine> vmList = vmh.getByName(nameToTest);
//		boolean allHaveExpectedName = true;
//		
//		System.out.println("getByNameTest");
//		
//		for (VendingMachine vm : vmList) {
//			System.out.println("VendingMachine id " + vm.getId() + " name is " + vm.getName());
//			if (!nameToTest.equals(vm.getName())) {
//				allHaveExpectedName = false;
//				break;
//			}
//		}
//		assertTrue(allHaveExpectedName);
//	}
//	
//	@Test
//	public void getByPopularityHighestTest() {
//		List<VendingMachine> vmList = vmh.getByPopularityHighest();
//		System.out.println("getByPopularityHighestTest");
//		for (VendingMachine vm : vmList) {
//			System.out.println(vm);
//		}
//		// TODO this is not a proper test yet, but prints results to console for "testing" purposes.
//		// The "tested" function does appear to work properly though.
//		assertTrue(false); 
//	}
//	
//	@Test
//	public void getByPopularityLowestTest() {
//		List<VendingMachine> vmList = vmh.getByPopularityLowest();
//		System.out.println("getByPopularityLowestTest");
//		for (VendingMachine vm : vmList) {
//			System.out.println(vm);
//		}
//		// TODO this is not a proper test yet, but prints results to console for "testing" purposes.
//		// The "tested" function does appear to work properly though.
//		assertTrue(false); 
//	}
	
	
	
	@Test
	public void addTest() {
		// TODO
		VendingMachine vendo = new VendingMachine();
		
		vendo.setName("myvendo");
		vendo.setMainColor("000");
		vendo.setSecondaryColor("fff");
		vendo.setDescription("");
		vendo.setTheme("default");
		vendo.setSnacks(null);
		vendo.setId(vms.add(vendo));
		assertTrue(vendo.getId() >= 1);
	}
	/*
	@Test
	public void getByIdTest() {
		// TODO
	}
	
	@Test
	public void getAllTest() {
		// TODO
	}
	*/
	@Test
	public void updateTest() {
		//adding snacks
		Snack s=new Snack();
		s.setDescription("VendingMachineUpdateSnack1");
		s.setId(sdao.add(s));
		Snack s2=new Snack();
		s2.setDescription("VendingMachineUpdateSnack2");
		s2.setId(sdao.add(s2));
		List<Snack> listA=new ArrayList<Snack>();
		listA.add(s);
		listA.add(s2);
				
		//Vending 
		VendingMachine vendo = new VendingMachine();
		
		vendo.setName("myvendoupdate");
		vendo.setMainColor("000");
		vendo.setSecondaryColor("fff");
		vendo.setDescription("");
		vendo.setTheme("default");
		vendo.setSnacks(null);
		vendo.setId(vmh.add(vendo));
		
		vendo.setSnacks(listA);
		vmh.update(vendo);
		
		assertTrue(vmh.getById(vendo.getId()).getSnacks().size()==2);
	}
	/*
	@Test
	public void deleteTest() {
		// TODO
	}
	
	@Test
	public void getByTypeTest() {
		// TODO
	}
	
	*/
	
}
