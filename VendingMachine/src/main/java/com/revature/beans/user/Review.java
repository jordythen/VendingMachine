package com.revature.beans.user;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.beans.vendingmachine.VendingMachine;
@Entity
@Table(name="REVIEW")
public class Review {
	@Id 
	@SequenceGenerator(name="reviewGen", sequenceName="review_seq", allocationSize=1)
	@GeneratedValue(generator="reviewGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="VENDINGMACHINE", joinColumns=@JoinColumn(name="id") )
	private VendingMachine targetVendingMachine;
	
	//One star to five stars!!!!
	@Column(name="rating")
	private Integer starRating;
	private String comments;
	
	private String reviewTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public VendingMachine getTargetVendingMachine() {
		return targetVendingMachine;
	}
	public void setTargetVendingMachine(VendingMachine targetVendingMachine) {
		this.targetVendingMachine = targetVendingMachine;
	}
	public Integer getStarRating() {
		return starRating;
	}
	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", targetVendingMachine=" + targetVendingMachine + ", starRating=" + starRating
				+ ", comments=" + comments + ", reviewTime=" + reviewTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reviewTime == null) ? 0 : reviewTime.hashCode());
		result = prime * result + ((starRating == null) ? 0 : starRating.hashCode());
		result = prime * result + ((targetVendingMachine == null) ? 0 : targetVendingMachine.hashCode());
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
		Review other = (Review) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reviewTime == null) {
			if (other.reviewTime != null)
				return false;
		} else if (!reviewTime.equals(other.reviewTime))
			return false;
		if (starRating == null) {
			if (other.starRating != null)
				return false;
		} else if (!starRating.equals(other.starRating))
			return false;
		if (targetVendingMachine == null) {
			if (other.targetVendingMachine != null)
				return false;
		} else if (!targetVendingMachine.equals(other.targetVendingMachine))
			return false;
		return true;
	}
	
}
