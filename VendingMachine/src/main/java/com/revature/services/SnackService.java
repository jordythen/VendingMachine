package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.snack.Snack;
import com.revature.data.SnackHibernate;

@Service
public class SnackService implements GenericService<Snack>{
	SnackHibernate shib;
	
	@Autowired
	public SnackService(SnackHibernate t) {
		shib=t;
	}
	@Override
	public Integer add(Snack t) {
		
		return shib.add(t);
	}

	@Override
	public Snack getById(Integer id) {
		
		return shib.getById(id);
	}

	@Override
	public List<Snack> getAll() {
		
		return shib.getAll();
	}

	@Override
	public void update(Snack t) {
		shib.update(t);
		
	}

	@Override
	public void delete(Snack t) {
		shib.delete(t);
		
	}

}
