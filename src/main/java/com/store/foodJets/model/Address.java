package com.store.foodJets.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;
	private String address;

	public Address() {
		
	}

	public Address(Long id, User user, String address) {
		super();
		this.id = id;
		this.user = user;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", user=" + user + ", address=" + address + "]";
	}

}
