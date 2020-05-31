package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.user.Order;
import com.revature.utils.HibernateUtil;

@Repository
public class OrderHibernate implements OrderDAO {
	
	private HibernateUtil conn = HibernateUtil.getHibernateUtil();
	Logger logger = Logger.getLogger(OrderHibernate.class);

	@Override
	public Integer add(Order t) {
		logger.trace("adding Order: " + t);
		Session session = conn.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				logger.trace("Exception occured when adding order: " + e);
				logger.trace("Transaction: " + transaction);
				logger.trace("Order: " + t);
			}
		}
		finally {
			session.close();
		}
		return t.getId();
	} // end add method

	@Override
	public Order getById(Integer id) {
		logger.trace("Getting order by id" + id);
		Session session = conn.getSession();
		Order order = session.get(Order.class, id);
			
		if(order == null) {
			logger.trace("Session contains: " + order);
			
		}
		
		logger.trace(order + " Returned from Session");
		
		session.close();
		return order;
	} // end getById method

	@Override
	public List<Order> getAll() {
		logger.trace("Getting all orders");
		
		Session session = conn.getSession();
		String HQL = "From Order";
		Query<Order> orderQuery = session.createQuery(HQL,Order.class);
		List<Order> orderList = orderQuery.getResultList();
		
		if (orderList == null) {
			logger.trace("The List of Orders returned: " + orderList);
		}
		
		
		logger.trace("Orders in List are: " + orderList);
		session.close();
		return orderList;
	}// end getAll method

	@Override
	public void update(Order t) {
		logger.trace("Order being updated: " + t);
		Session session = conn.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(t);
			if(transaction != null) {

				transaction.commit();
				logger.trace("Order updated with: " + t);
			}
			else {
				logger.trace("There was a problem updating. Transaction contained: " + transaction);

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
	}//end update method

	@Override
	public void delete(Order t) {
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
				logger.trace("There was a problem with the transaction: " + e);
			}	
		}
		finally {
			session.close();
			
		}
	}	// end delete method

}// end class
