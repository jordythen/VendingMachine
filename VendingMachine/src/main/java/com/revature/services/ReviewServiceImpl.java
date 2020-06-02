package com.revature.services;

import java.util.List;

import com.revature.beans.user.Review;
import com.revature.data.ReviewDAO;
import com.revature.data.ReviewHibernate;

public class ReviewServiceImpl implements ReviewService {
	ReviewDAO rDAO;
	public ReviewServiceImpl()
	{
		rDAO = new ReviewHibernate();
	}

	@Override
	public Integer add(Review t) {
		return rDAO.add(t);
	}

	@Override
	public Review getById(Integer id) {
		return rDAO.getById(id);
	}

	@Override
	public List<Review> getAll() {
		return rDAO.getAll();
	}

	@Override
	public void update(Review t) {
		rDAO.update(t);

	}

	@Override
	public void delete(Review t) {
		rDAO.delete(t);
	}

}
