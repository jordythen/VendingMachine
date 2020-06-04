package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.snack.Snack;
import com.revature.beans.user.Offer;
import com.revature.beans.user.User;
import com.revature.data.OfferHibernate;

@Service
public class OfferService implements GenericService<Offer>{
	private Logger log = Logger.getLogger(OfferService.class);
	private OfferHibernate offer;
	
	@Autowired
	public OfferService(OfferHibernate o) {
		offer=o;
	}

	@Override
	public Integer add(Offer t) {
		
		return offer.add(t) ;
	}
	@Override
	public Offer getById(Integer id) {
		
		return offer.getById(id);
	}
	@Override
	public List<Offer> getAll() {
		
		return offer.getAll();
	}
	@Override
	public void update(Offer t) {
		
		offer.update(t);
		
	}
	@Override
	public void delete(Offer t) {
		offer.delete(t);
	}
	
	public List<Offer> getOtherUsersOffersForMySnacks(User seller){
		List<Snack> usersnacks=seller.getVendingMachine().getSnacks();
		List<Offer> myOffers=new ArrayList<Offer>();
		List<Offer> allOffers=offer.getAll();
		
		for (Offer o:allOffers) {
			LoopA: for(Snack s:o.getSnacksOfInterest()) {
				for(Snack mysnack:usersnacks) {
					if(s.getId()==mysnack.getId()) {
						myOffers.add(o);
						break LoopA;
					}
				}
			}
		}
		
		return myOffers;
	}
	
	
}
