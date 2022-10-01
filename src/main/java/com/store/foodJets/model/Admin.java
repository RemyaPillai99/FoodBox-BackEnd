package com.store.foodJets.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
//@DiscriminatorValue("Admin")
public class Admin {
	@Id
	private String emailId;
	private String password;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [emailId=" + emailId + ", password=" + password + "]";
	}
	
	

}
