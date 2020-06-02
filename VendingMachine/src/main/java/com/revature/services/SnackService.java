package com.revature.services;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.snack.Snack;
import com.revature.beans.user.User;
import com.revature.beans.vendingmachine.VendingMachine;
import com.revature.data.SnackHibernate;
import com.revature.data.VendingMachineHibernate;

@Service
public class SnackService implements GenericService<Snack>{
	private Logger log = Logger.getLogger(SnackService.class);
	private SnackHibernate shib;
	private VendingMachineService vmhib;
	private UserService userv;
	@Autowired
	public SnackService(SnackHibernate t, VendingMachineService v, UserService p) {
		shib=t;
		vmhib=v;
		userv=p;
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
	
	public void buySnackFromVendingMachine(Snack s, VendingMachine buyer) {
		List<VendingMachine> allvm=vmhib.getAll();
		
		for (VendingMachine vm :allvm) {
			List<Snack> slist=vm.getSnacks();
			Iterator<Snack> snackit=slist.iterator();
			boolean hassnack=false;
			while (snackit.hasNext()) {
				Snack snack=snackit.next();
				if (snack.getId()==s.getId()) {
					hassnack=true;
					snackit.remove();
				}
			}
			
			if (hassnack) {
				log.trace("VM: "+vm+" has had snack: "+s+" removed");
				vm.setSnacks(slist);
				vmhib.update(vm); // removing snack from vending machine
				
				List<User> ulist=userv.getAll(); // increasing sellers balance
				for (User u:ulist) {
					if (u.getVendingMachine().getId()==vm.getId()) {
						u.setBalance(u.getBalance()+s.getCost());
						userv.update(u);
					}
				}
				
			}
		}
		
		List<Snack> buyersnacks=buyer.getSnacks();
		buyersnacks.add(s); //adding snack to buyer vending machine
		buyer.setSnacks(buyersnacks);
		vmhib.update(buyer);
		
		log.trace("VM: "+buyer+" has had snack: "+s+" added");
	}

}
