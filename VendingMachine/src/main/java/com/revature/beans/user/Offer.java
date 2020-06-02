package com.revature.beans.user;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.beans.snack.Snack;
import com.revature.beans.vendingmachine.VendingMachine;
@Entity
@Table(name="OFFER")
public class Offer {
	
	@Id 
	@SequenceGenerator(name="offerGen", sequenceName="offer_seq", allocationSize=1)
	@GeneratedValue(generator="offerGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	//ASK SIERRA IF THIS IS CORRECT
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="SNACKOFFER", joinColumns=@JoinColumn(name="offerID"),
									inverseJoinColumns=@JoinColumn(name="snacksOfInterestID"))
	private Set<Snack> snacksOfInterest;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="SNACKOFFER", joinColumns=@JoinColumn(name="offerID"),
									inverseJoinColumns=@JoinColumn(name="snacksToOfferID"))
	private Set<Snack> snacksToOffer;
	
	//Leave this alone for now, remember to set this later
	@Column(name="statusType")
	private String status;
	private String timeOfferWasMade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Snack> getSnacksOfInterest() {
		return snacksOfInterest;
	}
	public void setSnacksOfInterest(Set<Snack> snacksOfInterest) {
		this.snacksOfInterest = snacksOfInterest;
	}
	public Set<Snack> getSnacksToOffer() {
		return snacksToOffer;
	}
	public void setSnacksToOffer(Set<Snack> snacksToOffer) {
		this.snacksToOffer = snacksToOffer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeOfferWasMade() {
		return timeOfferWasMade;
	}
	public void setTimeOfferWasMade(String timeOfferWasMade) {
		this.timeOfferWasMade = timeOfferWasMade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((snacksOfInterest == null) ? 0 : snacksOfInterest.hashCode());
		result = prime * result + ((snacksToOffer == null) ? 0 : snacksToOffer.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeOfferWasMade == null) ? 0 : timeOfferWasMade.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (snacksOfInterest == null) {
			if (other.snacksOfInterest != null)
				return false;
		} else if (!snacksOfInterest.equals(other.snacksOfInterest))
			return false;
		if (snacksToOffer == null) {
			if (other.snacksToOffer != null)
				return false;
		} else if (!snacksToOffer.equals(other.snacksToOffer))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeOfferWasMade == null) {
			if (other.timeOfferWasMade != null)
				return false;
		} else if (!timeOfferWasMade.equals(other.timeOfferWasMade))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", snacksOfInterest=" + snacksOfInterest + ", snacksToOffer=" + snacksToOffer
				+ ", status=" + status + ", timeOfferWasMade=" + timeOfferWasMade + "]";
	}
	
	
}
