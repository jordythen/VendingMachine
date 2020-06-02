package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.snack.Type;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.data.VendingMachineHibernate;

@Service
public class VendingMachineService implements GenericService<VendingMachine> {
	VendingMachineHibernate vmh;
	
	@Autowired
	public VendingMachineService(VendingMachineHibernate t) {
		vmh = t;
	}
	
	@Override
	public Integer add(VendingMachine vm) {
		return vmh.add(vm);
	}

	@Override
	public VendingMachine getById(Integer id) {
		return vmh.getById(id);
	}
	

	@Override
	public List<VendingMachine> getAll() {
		return vmh.getAll();
	}

	@Override
	public void update(VendingMachine vm) {
		vmh.update(vm);
	}

	@Override
	public void delete(VendingMachine vm) {
		vmh.delete(vm);
	}
	
	public List<VendingMachine> getByName(String name) {
		return vmh.getByName(name);
	}
	
	public List<VendingMachine> getByType(Type t){
		return vmh.getByType(t);
		
	}
	
	public List<VendingMachine> getByHighestPopularity(){
		return vmh.getByPopularityHighest();
	}
	
	public List<VendingMachine> getByLowestPopularity(){
		return vmh.getByPopularityLowest();
	}
	
	

}
