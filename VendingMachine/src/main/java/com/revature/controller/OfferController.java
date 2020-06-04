package com.revature.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.beans.snack.Snack;
import com.revature.beans.user.Offer;
import com.revature.beans.user.User;
import com.revature.services.OfferService;
import com.revature.services.SnackService;
import com.revature.services.UserService;
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(path = "/offer")
public class OfferController {
	
	public Logger logger = Logger.getLogger(OfferController.class);
	private OfferService offerServ;
	private SnackService snackServ;
	private UserService userv;
	
	@Autowired
	public OfferController(OfferService oS, SnackService sS, UserService uS) {
		offerServ = oS;
		snackServ = sS;
		userv = uS;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id){
		
		Offer offer = offerServ.getById(id);
		
		logger.trace(offer + " Returned from id of: " + id);
		
		if( offer == null) {
			logger.warn("Offer = " + offer);
			return ResponseEntity.notFound().build();
		}
		
		
		return ResponseEntity.ok(offer);
	}
	
	@GetMapping
	public ResponseEntity< List<Offer> > getAll(){
		
		 List<Offer> offerList = offerServ.getAll();
		
		 logger.trace("All offers returned: " + offerList);
		
		
		 return ResponseEntity.ok(offerList);
		
	}
	
	@GetMapping
	public ResponseEntity< Set<Offer> > getOffersForUser(User user){
		
		Set<Offer> offers = user.getPendingOffers();
		
		logger.trace("User: " + user + "has pending offers of: " + offers);
				
		// DO NOT DELETE THIS
		// snackOfInterest = offer.getSnacksOfInterest();
//			snacksOfInterest.forEach((n) -> {if (snacksOfInterest != null)
//				snackServ.getById(n.getId());});
			
			return ResponseEntity.ok(offers);
		
	}
	
	@GetMapping
	public ResponseEntity< Set<Snack> > getSnacksofInterest(Offer offer){
		
		Set<Snack> snacksOfInterest = offer.getSnacksOfInterest();
		
		logger.trace("snacks of interest returned = " + snacksOfInterest);
		
		return ResponseEntity.ok(snacksOfInterest);
	}
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<Offer> addOffer(@RequestBody Offer offer, HttpSession session){
		
		// there are two methods to add an offer in offerHibernate. This is the method that
		// does not return an id
		offerServ.addOffer(offer);
		updateSessionUser(session);
		
		logger.trace(offer + " Added");
		logger.trace("Session contains: " + session);
		
		return ResponseEntity.ok(offer);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Offer> deleteOffer(@PathVariable("id") Integer id, HttpSession session){
		
		Offer offerToBeDeleted = offerServ.getById(id);
		
		offerServ.delete(offerToBeDeleted);
		updateSessionUser(session);
		
		logger.trace(offerToBeDeleted + " Deleted");
		logger.trace("Session contains: " + session);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Offer> updateOffer(@PathVariable("id") Offer offer, HttpSession session){
		
		offerServ.update(offer);
		updateSessionUser(session);
		
		logger.trace(offer + " updated to Offer");
		logger.trace("Session contains: " + session);
		
		return ResponseEntity.ok(offerServ.getById(offer.getId()));
		
	}
	
	
	public void updateSessionUser(HttpSession session) {
		User u=(User) session.getAttribute("user");
		User u2=userv.getById(u.getId());
		session.setAttribute("user", u2);
	}
	
}