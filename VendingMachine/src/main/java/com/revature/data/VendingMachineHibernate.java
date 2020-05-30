package com.revature.data;

import java.util.List;

import org.hibernate.query.Query;

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
		VendingMachine vm = s.get(VendingMachine.class, id);
		log.trace("Got user with id "+ vm.getId());
		return vm;
	}
	
	/* Get all VendingMachines */
	@Override
	public List<VendingMachine> getAll() {
		log.trace("Getting all VendingMachines from the database");
		Session s = connection.getSession();
		String hql = "FROM vendingmachine";
		Query<VendingMachine> q = s.createQuery(hql, VendingMachine.class);
		List<VendingMachine> vmList = q.getResultList();
		s.close();
		return vmList;
	}
	
	/* Update a VendingMachine */
	@Override
	public void update(VendingMachine vm) {
		log.trace("Updating VendingMachine " + vm.getName());
		Session s = connection.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(vm);
			tx.commit();
			log.trace("VendingMachine updated");
		}
		catch(Exception e){
			if(tx != null) {
				tx.rollback();
				log.warn(e);
			}
		}
		finally {
			s.close();
		}
	}
	
	/* Delete a VendingMachine */
	@Override
	public void delete(VendingMachine vm) {
		log.trace("Deleteing VendingMachine " + vm);
		Session s = connection.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(vm);
			tx.commit();
			log.trace("Deleted VendingMachine " + vm.getName() + " successfully");
		}
		catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				log.warn(e);
			}
		}
		finally {
			s.close();
		}
	}
	
	/* 5.5 User can search for other people's VendingMachine by name */
	@Override
	public List<VendingMachine> getByName(String name) {
		log.trace("Getting VendingMachines with name "+ name);
		Session s = connection.getSession();
		String hql = "FROM vendingmachine V WHERE V.vending_name = name";
		Query<VendingMachine> q = s.createQuery(hql, VendingMachine.class);
		List<VendingMachine> vmList = q.getResultList();
		log.trace("Got VendingMachines with name "+ name);
		return vmList;
	}
	
	/* 5.7 User can search for other people's VendingMachine 
	   ordered by popularity(highest rating first) */
	@Override
	public List<VendingMachine> getByPopularityHighest() {
		/*
		log.trace("Getting VendingMachines by popularity HIGHEST first");
		Session s = connection.getSession();
		
		// TODO need to figure our joining, grouping, etc for hql or sql...
		//String hql = "SELECT vendingmachine FROM review ORDER BY rating desc";
		// ...need to get all reviews, group by VandingMachinId average the rating, 
		// 		then select the vending machines?
		
		Query<VendingMachine> q = s.createQuery(hql, VendingMachine.class);
		List<VendingMachine> vmList = q.getResultList();
		log.trace("Got VendingMachines by popularity HIGHEST first");
		return vmList;
		*/
		return null;
	}
	
	/* 5.8 User can search for other people's VendingMachine 
	   ordered by popularity(lowest rating first) */
	@Override
	public List<VendingMachine> getByPopularityLowest() {
		/*
		log.trace("Getting VendingMachines by popularity LOWEST first");
		Session s = connection.getSession();
		
		// TODO need to figure our joining, grouping, etc for hql or sql...
		
		Query<VendingMachine> q = s.createQuery(hql, VendingMachine.class);
		List<VendingMachine> vmList = q.getResultList();
		log.trace("Got VendingMachines by popularity LOWEST first");
		return vmList;
		*/
		return null;
	}
	
	/* 5.9 User can search for other people's VendingMachine by Type */
	@Override
	public List<VendingMachine> getByType(Type t) {
		
		/*
		log.trace("Getting VendingMachines by Type " + t.getSnacktype());
		Session s = connection.getSession();
		
		// TODO need to figure our joining, grouping, etc for hql or sql...
		// ...Type is for snacks... so need to get all machines having any snack of that type?
		
		Query<VendingMachine> q = s.createQuery(hql, VendingMachine.class);
		List<VendingMachine> vmList = q.getResultList();
		log.trace("Got VendingMachines by Type " + t.getSnacktype());
		return vmList;
		*/
		return null;
	}

}
