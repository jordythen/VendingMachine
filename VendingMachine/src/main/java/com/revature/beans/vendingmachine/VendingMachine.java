package com.revature.beans.vendingmachine;

import java.util.Set;

import javax.persistence.*;
import com.revature.beans.snack.Snack;
import com.revature.beans.user.Review;

@Entity
@Table(name="VENDINGMACHINE")
public class VendingMachine {
	
	@Id 
	@SequenceGenerator(name="vendingmachineGen", sequenceName="vendingmachine_seq", allocationSize=1)
	@GeneratedValue(generator="vendingmachineGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="vending_name")
	private String name;
	@Column(name="descript")
	private String description;
	private String theme;
	
	//These will be stored in HEX
	@Column(name="main_color")
	private String mainColor;
	@Column(name="secondary_color")
	private String secondaryColor;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="REVIEW", joinColumns=@JoinColumn(name="vendingmachineID"),
											inverseJoinColumns=@JoinColumn(name="id"))
	private Set<Review> ratings;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="SNACK", joinColumns=@JoinColumn(name="vendingmachineID"),
											inverseJoinColumns=@JoinColumn(name="id"))
	private Set<Snack> snacks;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public Set<Review> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Review> ratings) {
		this.ratings = ratings;
	}

	public Set<Snack> getSnacks() {
		return snacks;
	}

	public void setSnacks(Set<Snack> snacks) {
		this.snacks = snacks;
	}


	@Override
	public String toString() {
		return "VendingMachine [id=" + id + ", name=" + name + ", description=" + description + ", theme=" + theme
				+ ", mainColor=" + mainColor + ", secondaryColor=" + secondaryColor + ", ratings=" + ratings
				+ ", snacks=" + snacks + ", hiddenSnacks=" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mainColor == null) ? 0 : mainColor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + ((secondaryColor == null) ? 0 : secondaryColor.hashCode());
		result = prime * result + ((snacks == null) ? 0 : snacks.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
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
		VendingMachine other = (VendingMachine) obj;
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
		if (mainColor == null) {
			if (other.mainColor != null)
				return false;
		} else if (!mainColor.equals(other.mainColor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (secondaryColor == null) {
			if (other.secondaryColor != null)
				return false;
		} else if (!secondaryColor.equals(other.secondaryColor))
			return false;
		if (snacks == null) {
			if (other.snacks != null)
				return false;
		} else if (!snacks.equals(other.snacks))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
	
	
	
}
