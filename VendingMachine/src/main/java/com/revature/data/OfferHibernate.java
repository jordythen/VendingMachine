package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.user.Offer;
import com.revature.beans.user.User;
import com.revature.utils.HibernateUtil;

public class OfferHibernate implements OfferDAO {
	
	private HibernateUtil conn = HibernateUtil.getHibernateUtil();
	Logger logger = Logger.getLogger(OfferHibernate.class);

	@Override
	public Integer add(Offer t) {
		logger.trace("adding Offer: " + t);
		Session session = conn.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			logger.trace(t + " Added as an offer");
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				logger.trace("Exception occured when adding Offer  " + e );
				logger.trace("Transaction: " + transaction);
				logger.trace("Offer: " + t);
			}
		}
		finally {
			session.close();
		}

		return t.getId();
	}

	@Override
	public Offer getById(Integer id) {
		logger.trace("Getting offer by id of: " + id);
		Session session = conn.getSession();
		Offer offer = session.get(Offer.class, id);
		
		if(offer == null) {
			logger.trace("Session contains a " + offer + " offer");
		}
		
		logger.trace(offer + " Returned from Session");
	
		session.close();
		return offer;
	} // end getById method

	// This seems like a strange utility to have, however I'll 
	// give it functionality. The only use I could see for it right 
	// now is loading in ALL of the offers made, then retrieving
	// specific offers within the service layer from the list of
	// all offers... Just like what Michael did in his last project.
	// ..which, shout out to Michael..that was smart!
	// If we choose this implementation then the methods
	// for getting offers by vending id or user id within this class
	// wont be needed, as this would be a service layer function rather
	// than a data layer function, jah feel?
	@Override
	public List<Offer> getAll() {
		logger.trace("SHOW ME THE MONEY!");
		
		Session session = conn.getSession();
		String HQL = "FROM Offer";
		Query<Offer> offerQuery = session.createQuery(HQL, Offer.class);
		List<Offer> offerList = offerQuery.getResultList();
		
		if(offerList == null) {
			logger.trace("The List of Offers contained " + offerList + " values");
		}
		
		logger.trace("Offers in List are: " + offerList);
		session.close();
		return offerList;
	}// end getAll method

	// status type would be the only field to update
	@Override
	public void update(Offer t) {
		logger.trace("Offer being updated: " + t);
		Session session = conn.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(t);
			
			if(transaction != null) {
				transaction.commit();
				logger.trace("Offer updated with: " + t);
			}
			else {
				logger.trace("there was a problem updating. Transaction contained: " + transaction);
				
			}
			
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				logger.trace(e);
			}
		}
		finally {
			session.close();
		}
		
	} // end update method

	@Override
	public void delete(Offer t) {
		logger.trace("Deleting: " + t);
		Session session = conn.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(t);
			if(transaction != null) {
				transaction.commit();
				logger.trace(t + " Deleted successfully");
			}
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				logger.trace("There was a problem deleting: " + t );
			}
		}
		finally {
			session.close();
		}
		
	}// end delete method

	@Override
	public List<Offer> getAllOffersByVendingID(Integer id) {
		logger.trace("Getting offer from Vending Machine number: " + id);
		
		Session session = conn.getSession();
		String HQL = "From Offer where vendingmachineId=:id";
		Query<Offer> query = session.createQuery(HQL, Offer.class);
		query.setParameter("id", id);
		List<Offer> offerList = query.getResultList();
		
		logger.trace("Found " + offerList.size() + " results");
		
		session.close();
		
		return offerList;
	}

	@Override
	public List<Offer> getAllOffersByUserID() {
		return null;
	}

	
	@Override
	public void deleteOfferById(int id) {
	logger.trace("Deleting offer by ID of: " + id);
	Session session = conn.getSession();
	Transaction transaction = session.beginTransaction();
	
	try {
		
	@SuppressWarnings("rawtypes")
	Query query = session.createQuery("delete from Offer where id=:id"); 
	query.setParameter("id", id);
	
	int result = query.executeUpdate();
	if(result != 0) {
		
		logger.trace("Offer of ID: " + id + " Deleted");
		transaction.commit();
			
	}
	}
	catch(Exception e) {
		if (transaction != null) {
			
			transaction.rollback();
			logger.trace("Problem Deleting...");
			logger.trace("Transaction contains: " + transaction);
			logger.trace(e);
		}
	}
	finally {
		session.close();
	}
		
	}// end deleteById method

}// end offerHibernate Class
