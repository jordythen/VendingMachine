package com.revature.data;

import java.util.List;

//This is our generic methods of adding and deleting stuff into the database/data set.
public interface GenericDAO<T> {

	public Integer add(T t);
	public T getById(Integer id);
	public List<T> getAll();
	public void update(T t);
	public void delete(T t);
}
