package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.user.User;
import com.revature.data.UserHibernate;

@Service
public class UserService implements GenericService<User> {
	UserHibernate uhib;
	
	@Autowired
	public UserService(UserHibernate u) {
		uhib = u;
	}
	
	@Override
	public Integer add(User t) {
		// TODO Auto-generated method stub
		return uhib.add(t);
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return uhib.getById(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return uhib.getAll();
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		uhib.update(t);
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		uhib.delete(t);
	}
	
	public User getByUsernameAndPassword(String username, String password) {
		return uhib.getByUsernameAndPassword(username, password);
	}

}
