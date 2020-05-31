package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.snack.Snack;
import com.revature.utils.HibernateUtil;


public class SnackHibernate implements GenericDAO<Snack> {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();
	private Logger log = Logger.getLogger(SnackHibernate.class);
	@Override
	public Integer add(Snack t) {
		log.trace("Adding new snack");
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			
			s.save(t);  
			tx.commit();
			log.trace("Added snack successfully. Assigned id: " + t.getId());
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			log.trace("Exception in add snackHibernate");
		} finally {
			s.close();
		}
		return t.getId();
		
	}

	@Override
	public Snack getById(Integer id) {
		log.trace("Getting snack with id " + id);
		Session s = hu.getSession();
		
		Snack snack = s.get(Snack.class, id);
		s.close();
		log.trace("Got snack.");
		return snack;
	}

	@Override
	public List<Snack> getAll() {
		log.trace("Getting all snacks");
		Session s = hu.getSession();
		
		String query = "FROM SNACK";
		Query<Snack> q = s.createQuery(query, Snack.class);
		List<Snack> snackList = q.getResultList();
//		Set<Snack> snackSet = new HashSet<Snack>();
//		snackSet.addAll(snackList);
		s.close();
		log.trace("All snacks retrieved.");
		return snackList;
	}

	@Override
	public void update(Snack t) {
		log.trace("Updating snack with id " + t.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
			log.trace("Updated snack successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			log.trace("Exception in update snackHibernate");
		} finally {
			s.close();
		}
		
	}

	@Override
	public void delete(Snack t) {
		log.trace("Deleting snack with id " + t.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
			log.trace("Deleted snack successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			log.trace("Exception in delete snackHibernate");
		} finally {
			s.close();
		}
		
	}

}
