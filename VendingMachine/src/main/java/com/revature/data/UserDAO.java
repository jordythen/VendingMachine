package com.revature.data;

import com.revature.beans.user.User;

public interface UserDAO extends GenericDAO<User> {

	public User getByUsernameAndPassword(String username, String password);
}
