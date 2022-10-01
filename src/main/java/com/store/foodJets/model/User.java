package com.store.foodJets.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;*/

@Entity
@Table(name = "USER")

/*
 * @Getter
 * 
 * @Setter
 * 
 * @NoArgsConstructor
 * 
 * @ToString
 */

public class User {

	@Id
	private String emailId;

	@Column(length = 20)
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String phoneNum;

	@Column
	private String address;

	// address id will be mentioned in Address table

	public User() {
	}

	public User(String emailId, String password, String firstName, String lastName, String phoneNum, String address) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNum=" + phoneNum + ", address=" + address + "]";
	}

}
