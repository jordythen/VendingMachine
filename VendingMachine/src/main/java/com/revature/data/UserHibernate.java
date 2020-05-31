package com.revature.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.user.User;
import com.revature.utils.HibernateUtil;

@Repository
public class UserHibernate implements UserDAO{
	private HibernateUtil connection = HibernateUtil.getHibernateUtil();
	Logger log = Logger.getLogger(UserHibernate.class);
	
	@Override
	public Integer add(User t) {
		// TODO Auto-generated method stub
		log.trace("Adding user "+ t +" to the database");
		Session s = connection.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			log.trace("Saving.....");
			s.save(t);

			tx.commit();
			log.trace("Successfully added person " + t.getFirstName());
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				log.warn(e);
			}
		}finally {
			s.close();
		}
		
		return t.getId();
	}

	@Override
	public User getById(Integer id) {
		log.trace("Getting person with id "+ id);
		Session s = connection.getSession();
		log.trace("Hibernate session has been made");
		User u = s.get(User.class, id);
		log.info("THIS IS USER: " + u);
		//log.trace("Got user with id "+ u.getId());
		// For this log.trace if getById returns null, the above commented out line will cause error because u has no id
		return u;
	}

	@Override
	public List<User> getAll() {
		log.trace("Getting all users from the database");
		Session s = connection.getSession();
		String hql = "FROM User";
		Query<User> q = s.createQuery(hql, User.class);
		List<User> userList = q.getResultList();
		s.close();
		return userList;
	}

	@Override
	public void update(User t) {
		log.trace("updating user Id" + t.getId());
		Session s = connection.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
			log.trace("User updated");
			
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

	@Override
	public void delete(User t) {
		log.trace("Deleteing" + t);
		Session s = connection.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
			log.trace("Deleted " + t + " successfully");
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

	@Override
	public User getByUsernameAndPassword(String username, String password) {
		log.trace("Getting user by username: " + username + " and password " + password);
		Session s = connection.getSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<User> krit = cb.createQuery(User.class);
		Root<User> root = krit.from(User.class);
		
		Predicate predicateForUsername = cb.equal(root.get("username"), username);
		Predicate predicateForPassword = cb.equal(root.get("password"), password);
		Predicate predicateForUsernamePassword = cb.and(predicateForUsername, predicateForPassword);

		krit.select(root).where(predicateForUsernamePassword);
		
		User u = s.createQuery(krit).getSingleResult();
		
		return u;
	}
//	Session s = connection.getSession();
//	String sql = "SELECT FROM User WHERE username = :username AND passwd = :password";
//	NativeQuery<Object> nq = s.createNativeQuery(sql,Object.class);
//	nq.setParameter("username", username);
//	nq.setParameter("password", password);
//	User u = (User) nq.getResultStream();
//	log.trace("User retrieved is " + u);
//	s.close();
//	return u;

}
