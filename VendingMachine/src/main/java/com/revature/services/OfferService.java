package com.revature.services;
import java.util.List;
import com.revature.beans.user.Offer;
import com.revature.beans.user.User;
import com.revature.data.OfferHibernate;
public class OfferService implements GenericService<Offer>{
	
	private OfferHibernate offer;
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
	
	public void addOffer(Offer t) {
		
		offer.addOffer(t);
	}
	
	public void getPendingOffers(User user) {
		Integer userID = user.getId();
		offer.getAllOffersByUserID(userID);
	}
	
	
}