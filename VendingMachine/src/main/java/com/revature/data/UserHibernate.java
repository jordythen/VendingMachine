package com.revature.data;

import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.user.User;
import com.revature.utils.HibernateUtil;

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
			s.save(t);
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
		System.out.println("Getting person with id "+ id);
		Session s = connection.getSession();
		User u = s.get(User.class, id);
		log.trace("Got user with id "+id);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}
	

}
