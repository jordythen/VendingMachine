package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.user.Review;
import com.revature.data.ReviewDAO;
import com.revature.data.ReviewHibernate;

@Service
public class ReviewServiceImpl implements ReviewService {
	ReviewHibernate rh;
	
	@Autowired
	public ReviewServiceImpl(ReviewHibernate t)	{
		rh = t;
	}
	
	@Override
	public List<Review> getByMachineId(int id) {
		return rh.getByMachineId(id);
	}
	
	@Override
	public Integer add(Review t) {
		return rh.add(t);
	}

	@Override
	public Review getById(Integer id) {
		return rh.getById(id);
	}

	@Override
	public List<Review> getAll() {
		return rh.getAll();
	}

	@Override
	public void update(Review t) {
		rh.update(t);

	}

	@Override
	public void delete(Review t) {
		rh.delete(t);
	}

}
