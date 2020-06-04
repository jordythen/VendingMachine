package com.revature.services;

import java.util.List;

import com.revature.beans.user.Review;

public interface ReviewService extends GenericService<Review> {
	
	public List<Review> getByMachineId(int id);
	
}
