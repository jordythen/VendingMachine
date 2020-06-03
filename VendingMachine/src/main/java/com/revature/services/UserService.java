package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.user.User;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.data.UserHibernate;
import com.revature.data.VendingMachineHibernate;

@Service
public class UserService implements GenericService<User> {
	UserHibernate uhib;
	VendingMachineHibernate vmhib;
	
	@Autowired
	public UserService(UserHibernate u, VendingMachineHibernate vm) {
		uhib = u;
		vmhib = vm;
	}
	
	//Adding a user will also add a vending machine.... since we set it up in our hibernate
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
	
	public User registerAccount(User t) {

		String userFullName= t.getFirstName() + " " + t.getLastName();
		VendingMachine vendo = new VendingMachine();
		vendo.setName(userFullName);
		vendo.setMainColor("#000000");
		vendo.setSecondaryColor("#FFFFFF");
		vendo.setDescription("");
		vendo.setTheme("default");
		vendo.setSnacks(null);
		vendo.setId(vmhib.add(vendo));
		
		t.setVendingMachine(vendo);
		t.setId(add(t));
		return t;
	}

}
