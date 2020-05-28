package com.revature.data;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> a81c8afd0dd3a282600c151085d30724bb789059

//This is our generic methods of adding and deleting stuff into the database/data set.
public interface GenericDAO<T> {

	public Integer add(T t);
	public T getById(Integer id);
	public List<T> getAll();
	public void update(T t);
	public void delete(T t);
}
