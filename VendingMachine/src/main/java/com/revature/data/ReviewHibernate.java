package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.user.Review;
import com.revature.utils.HibernateUtil;

@Repository
public class ReviewHibernate implements ReviewDAO {
	private HibernateUtil connection = HibernateUtil.getHibernateUtil();
	Logger log = Logger.getLogger(ReviewHibernate.class);
	
	@Override
	public List<Review> getByMachineId(int id) {
		Session s = connection.getSession();
		String sql = "SELECT * FROM review WHERE vendingmachineid = " + id;
		NativeQuery<Review> nq = s.createNativeQuery(sql, Review.class);
		List<Review> revList = nq.getResultList();
		log.trace("Got Reviews by VendingMachine id " + id);
		return revList;
	}
	
	@Override
	public Integer add(Review t) {
		log.trace("Adding user " + t + " to the database");
		Session s = connection.getSession();
		Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			log.trace("Saving.....");
			s.save(t);
			tx.commit();
			log.trace("Successfully added review " + t.getId());
		} catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
				log.warn(e);
			}
		} finally
		{
			s.close();
		}
		
		return t.getId();
	}

	@Override
	public Review getById(Integer id) {
		log.trace("Getting review with id " + id);
		Session s = connection.getSession();
		log.trace("Hibernate session has been made");
		Review r = s.get(Review.class, id);
		log.info("THIS IS REVIEW: " + r);
		s.close();
		log.trace("Got review with id " + r.getId());
		return r;
	}

	@Override
	public List<Review> getAll() {
		log.trace("Getting all reviews from the database");
		Session s = connection.getSession();
		String hql = "FROM Review";
		Query<Review> q = s.createQuery(hql, Review.class);
		List<Review> reviewList = q.getResultList();
		s.close();
		return reviewList;
	}

	@Override
	public void update(Review t) {
		log.trace("updating review with Id " + t.getId());
		Session s = connection.getSession();
		Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
			log.trace("Review Updated");
		} catch(Exception  e)
		{
			if(tx != null) {
				tx.rollback();
				log.warn(e);
			}
		} finally {
			s.close();
		}
	}

	@Override
	public void delete(Review t) {
		log.trace("Deleting" + t);
		Session s = connection.getSession();
		Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
			log.trace("Deleted " + t + "successfully");
		} catch(Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
				log.warn(e);
			}
		} finally
		{
			s.close();
		}
	}

}
