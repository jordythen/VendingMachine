package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.snack.Type;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.utils.HibernateUtil;

public class VendingMachineHibernate implements VendingMachineDAO {
	private HibernateUtil connection = HibernateUtil.getHibernateUtil();
	Logger log = Logger.getLogger(VendingMachineHibernate.class);
	
	/* Add a new VendingMachine */
	@Override
	public Integer add(VendingMachine vm) {
		log.trace("Adding VendingMachine "+ vm +" to the database");
		Session s = connection.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.save(vm);
			log.trace("Successfully added VendingMachine " + vm.getName());
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				log.warn(e);
			}
		}finally {
			s.close();
		}
		
		return vm.getId();
	}
	
	/* Get a VendingMachine by Id */
	@Override
	public VendingMachine getById(Integer id) {
		log.trace("Getting VendingMachine with id "+ id);
		Session s = connection.getSession();
		log.trace("Hibernate session has been made");
		VendingMachine vm = s.get(VendingMachine.class, id);
		log.info("THIS IS VendingMachine: " + vm);
		log.trace("Got user with id "+ vm.getId());
		return vm;
	}
	
	/* Get all VendingMachines */
	@Override
	public List<VendingMachine> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* Update a VendingMachine */
	@Override
	public void update(VendingMachine vm) {
		// TODO Auto-generated method stub
		
	}
	
	/* Delete a VendingMachine */
	@Override
	public void delete(VendingMachine vm) {
		// TODO Auto-generated method stub
		
	}
	
	/* 5.5 User can search for other people's VendingMachine by name */
	@Override
	public VendingMachine getByName(VendingMachine vm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 5.7 User can search for other people's VendingMachine 
	   ordered by popularity(highest rating first) */
	@Override
	public List<VendingMachine> getByPopularityHighest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 5.8 User can search for other people's VendingMachine 
	   ordered by popularity(lowest rating first) */
	@Override
	public List<VendingMachine> getByPopularityLowest() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 5.9 User can search for other people's VendingMachine by Type */
	@Override
	public List<VendingMachine> getByType(Type t) {
		// TODO Auto-generated method stub
		return null;
	}

}
