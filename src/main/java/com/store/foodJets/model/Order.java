package com.store.foodJets.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Order_placed")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long ID;
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "gross_total")
	private BigDecimal totalPrice;

	@Column
	private String status; // recieved inprogress on_way delivered

	@Column
	private String address;

	// delivery status
	// delivery addr - from addr table for customer

	// restaurant id -> more restaurants

	public Order() {

	}

	public Order(Long iD, User user, Date createdAt, BigDecimal totalPrice, String status, String address) {
		super();
		ID = iD;
		this.user = user;
		this.createdAt = createdAt;
		this.totalPrice = totalPrice;
		this.status = status;
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [ID=" + ID + ", user=" + user + ", createdAt=" + createdAt + ", totalPrice=" + totalPrice + "]";
	}


}
