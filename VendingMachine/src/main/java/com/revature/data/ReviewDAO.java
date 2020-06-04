package com.revature.data;

import java.util.List;

import com.revature.beans.user.Review;

public interface ReviewDAO extends GenericDAO<Review> {
	
	public List<Review> getByMachineId(int id);
	
}
