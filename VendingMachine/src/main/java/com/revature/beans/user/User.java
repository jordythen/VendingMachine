package com.revature.beans.user;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.beans.vendingmachine.VendingMachine;

//If name is different that you have to specify the name of the table in SQL
//ie.... @Table (name="user_table")
@Entity
@Table(name="USERTABLE")
public class User {
	//If we have a different name in the SQL, you want to specify the column
	//ie.... @Column(name="userId")
	@Id 
	@SequenceGenerator(name="userGen", sequenceName="user_seq", allocationSize=1)
	@GeneratedValue(generator="userGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="first_name") //implicit
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	private String username;
	@Column(name="passwd")
	private String password;
	private Double balance;
	
//	//We're setting up our one to one
//	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinTable(name="VENDINGMACHINE", joinColumns=@JoinColumn(name="id") )
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_VENDINGMACHINE", joinColumns=@JoinColumn(name="user_id"),
									inverseJoinColumns=@JoinColumn(name="vendingmachine_id"))
	private VendingMachine vendingMachine;
	
	//Setting up our one to many table
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_OFFER", joinColumns=@JoinColumn(name="user_id"),
								inverseJoinColumns=@JoinColumn(name="offer_id"))
	private Set<Offer> pendingOffers;
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_ORDER", joinColumns=@JoinColumn(name="user_id"),
									inverseJoinColumns=@JoinColumn(name="order_id"))
	private Set<Order> orderHistory;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_REVIEW", joinColumns=@JoinColumn(name="user_id"),
									inverseJoinColumns=@JoinColumn(name="review_id"))
	private Set<Review> ratingHistory;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public VendingMachine getVendingMachine() {
		return vendingMachine;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setVendingMachine(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	public Set<Offer> getPendingOffers() {
		return pendingOffers;
	}
	public void setPendingOffers(Set<Offer> pendingOffers) {
		this.pendingOffers = pendingOffers;
	}
	public Set<Order> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(Set<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}
	public Set<Review> getRatingHistory() {
		return ratingHistory;
	}
	public void setRatingHistory(Set<Review> ratingHistory) {
		this.ratingHistory = ratingHistory;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((orderHistory == null) ? 0 : orderHistory.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pendingOffers == null) ? 0 : pendingOffers.hashCode());
		result = prime * result + ((ratingHistory == null) ? 0 : ratingHistory.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((vendingMachine == null) ? 0 : vendingMachine.hashCode());
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
		User other = (User) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (orderHistory == null) {
			if (other.orderHistory != null)
				return false;
		} else if (!orderHistory.equals(other.orderHistory))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pendingOffers == null) {
			if (other.pendingOffers != null)
				return false;
		} else if (!pendingOffers.equals(other.pendingOffers))
			return false;
		if (ratingHistory == null) {
			if (other.ratingHistory != null)
				return false;
		} else if (!ratingHistory.equals(other.ratingHistory))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (vendingMachine == null) {
			if (other.vendingMachine != null)
				return false;
		} else if (!vendingMachine.equals(other.vendingMachine))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", balance=" + balance + ", vendingMachine="
				+ vendingMachine + ", pendingOffers=" + pendingOffers + ", orderHistory=" + orderHistory
				+ ", ratingHistory=" + ratingHistory + "]";
	}
}
