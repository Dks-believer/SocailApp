package com.masai.models;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class User {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	private String address;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(Integer userId, Customer customer, String address) {
		super();
		this.userId = userId;
		this.customer = customer;
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
