package com.revature.beans.snack;

import java.util.Set;

import javax.persistence.*;
<<<<<<< HEAD

=======
>>>>>>> a81c8afd0dd3a282600c151085d30724bb789059
@Entity
@Table(name="SNACK")
public class Snack {
	@Id 
	@SequenceGenerator(name="snackGen", sequenceName="snack_seq", allocationSize=1)
	@GeneratedValue(generator="snackGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	private Character isHidden;
	@Column(name="snack_name")
	private String snackName;
	@Column(name="snack_desc")
	private String description;
	@Column(name="quantity")
	private Integer numInStock;
	//nullable //HELLO2
	@Column(name="snack_cost")
	private Double cost;
	//A snack can have multiple types..
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="SNACK_SNACKTYPE",
				joinColumns=@JoinColumn(name="snackid"), 
				inverseJoinColumns=@JoinColumn(name="typeid"))
	private Set<Integer> typesId;
	private Set<Type> types;
	
	//These are counted on grams...
	@Column(name="total_fat")
	private Integer totalFat;
	@Column(name="total_carbs")
	private Integer totalCarbs;
	private Integer sodium;
	private Integer cholesterol;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSnackName() {
		return snackName;
	}
	public void setSnackName(String snackName) {
		this.snackName = snackName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumInStock() {
		return numInStock;
	}
	public void setNumInStock(Integer numInStock) {
		this.numInStock = numInStock;
	}
	public Set<Type> getTypes() {
		return types;
	}
	public void setTypes(Set<Type> types) {
		this.types = types;
	}
	public Integer getTotalFat() {
		return totalFat;
	}
	public void setTotalFat(Integer totalFat) {
		this.totalFat = totalFat;
	}
	public Integer getTotalCarbs() {
		return totalCarbs;
	}
	public void setTotalCarbs(Integer totalCarbs) {
		this.totalCarbs = totalCarbs;
	}
	public Integer getSodium() {
		return sodium;
	}
	public void setSodium(Integer sodium) {
		this.sodium = sodium;
	}
	public Integer getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(Integer cholesterol) {
		this.cholesterol = cholesterol;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Character getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Character isHidden) {
		this.isHidden = isHidden;
	}
	
	
	public Set<Integer> getTypesId() {
		return typesId;
	}
	public void setTypesId(Set<Integer> typesId) {
		this.typesId = typesId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cholesterol == null) ? 0 : cholesterol.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isHidden == null) ? 0 : isHidden.hashCode());
		result = prime * result + ((numInStock == null) ? 0 : numInStock.hashCode());
		result = prime * result + ((snackName == null) ? 0 : snackName.hashCode());
		result = prime * result + ((sodium == null) ? 0 : sodium.hashCode());
		result = prime * result + ((totalCarbs == null) ? 0 : totalCarbs.hashCode());
		result = prime * result + ((totalFat == null) ? 0 : totalFat.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		Snack other = (Snack) obj;
		if (cholesterol == null) {
			if (other.cholesterol != null)
				return false;
		} else if (!cholesterol.equals(other.cholesterol))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isHidden == null) {
			if (other.isHidden != null)
				return false;
		} else if (!isHidden.equals(other.isHidden))
			return false;
		if (numInStock == null) {
			if (other.numInStock != null)
				return false;
		} else if (!numInStock.equals(other.numInStock))
			return false;
		if (snackName == null) {
			if (other.snackName != null)
				return false;
		} else if (!snackName.equals(other.snackName))
			return false;
		if (sodium == null) {
			if (other.sodium != null)
				return false;
		} else if (!sodium.equals(other.sodium))
			return false;
		if (totalCarbs == null) {
			if (other.totalCarbs != null)
				return false;
		} else if (!totalCarbs.equals(other.totalCarbs))
			return false;
		if (totalFat == null) {
			if (other.totalFat != null)
				return false;
		} else if (!totalFat.equals(other.totalFat))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Snack [id=" + id + ", isHidden=" + isHidden + ", snackName=" + snackName + ", description="
				+ description + ", numInStock=" + numInStock + ", cost=" + cost + ", types=" + types + ", totalFat="
				+ totalFat + ", totalCarbs=" + totalCarbs + ", sodium=" + sodium + ", cholesterol=" + cholesterol + "]";
	}
	
}
