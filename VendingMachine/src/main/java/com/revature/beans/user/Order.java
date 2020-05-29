package com.revature.beans.user;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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
@Table(name="ORDERTABLE")
public class Order {
	@Id 
	@SequenceGenerator(name="orderGen", sequenceName="order_seq", allocationSize=1)
	@GeneratedValue(generator="orderGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="VENDINGMACHINE", joinColumns=@JoinColumn(name="id"))
	private VendingMachine orderMadeTo;
	
	private Double tax;
	private Double orderTotal;
	private String orderTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public VendingMachine getOrderMadeTo() {
		return orderMadeTo;
	}
	public void setOrderMadeTo(VendingMachine orderMadeTo) {
		this.orderMadeTo = orderMadeTo;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderMadeTo=" + orderMadeTo + ", tax=" + tax + ", orderTotal=" + orderTotal
				+ ", orderTime=" + orderTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderMadeTo == null) ? 0 : orderMadeTo.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((orderTotal == null) ? 0 : orderTotal.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderMadeTo == null) {
			if (other.orderMadeTo != null)
				return false;
		} else if (!orderMadeTo.equals(other.orderMadeTo))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (orderTotal == null) {
			if (other.orderTotal != null)
				return false;
		} else if (!orderTotal.equals(other.orderTotal))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		return true;
	}
	
}
