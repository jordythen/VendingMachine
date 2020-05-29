package com.revature.beans.snack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SNACKTYPE")
public class Type {
	
	@Id 
	@SequenceGenerator(name="typeGen", sequenceName="type_seq", allocationSize=1)
	@GeneratedValue(generator="typeGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String snacktype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSnacktype() {
		return snacktype;
	}

	public void setSnacktype(String snacktype) {
		this.snacktype = snacktype;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", snacktype=" + snacktype + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((snacktype == null) ? 0 : snacktype.hashCode());
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
		Type other = (Type) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (snacktype == null) {
			if (other.snacktype != null)
				return false;
		} else if (!snacktype.equals(other.snacktype))
			return false;
		return true;
	}
}
