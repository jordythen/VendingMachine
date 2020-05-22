package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//If name is different that you have to specify the name of the table in SQL
//ie.... @Table (name="user_table")
@Table
public class User {
	//If we have a different name in the SQL, you want to specify the column
	//ie.... @Column(name="userId")
	@Id 
	@SequenceGenerator(name="userGen", sequenceName="user_seq", allocationSize=1)
	@GeneratedValue(generator="userGen",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column //implicit
	private String firstName;
	@Column
	private String lastName;
	
	//We're setting up our one to one
	@OneToOne(fetch=FetchType.EAGER)
	private VendingMachine vendingMachine;
	
	/*
	@ManyToOne
	@JoinColumn(name="breed_id") //Specify the ID column in our userTable in the DB
	*/
	
	/* Many cats can have multiple special needs
	 * @ManyToMany(fetch=FetchType.EAGER)
	 * @JoinTable(name="cat_special_need",joinColumns=@JoinColumn(name="cat_id"), //cat owns special needs
	 * 				inverseJoinColumns=@JoinColumn(name="special_need_id"); //special needs are owned by the cat
	 */
	
}
