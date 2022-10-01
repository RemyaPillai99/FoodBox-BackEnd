package com.store.foodJets.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	private Long id;
	private String name;
	private String location; // address
	// city

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

}
