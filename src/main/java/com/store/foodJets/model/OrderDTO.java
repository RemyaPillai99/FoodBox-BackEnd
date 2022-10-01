package com.store.foodJets.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

//pojo class 
public class OrderDTO {
	
//	 id!:number;
//	    items!: CartItem[];
//	    totalPrice!:number;
//	    name!: string;
//	    emailId!: String;
//	    address!: string;
//	    //paymentId!: string;
//	    createdAt!: string;
//	    status!: string;
	
	public OrderDTO() {
		
	}
	private Long id;
	private CartItem[] items;
	private BigDecimal totalPrice ;
	private String name;
	private String emailId;
	private String address;
	private Date createdAt;
	private String status;
	private String transactionID;
	
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CartItem[] getItems() {
		return items;
	}
	public void setItems(CartItem[] items) {
		this.items = items;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public OrderDTO(Long id, CartItem[] items, BigDecimal totalPrice, String name, String emailId, String address,
			Date createdAt, String status, String transactionID) {
		super();
		this.id = id;
		this.items = items;
		this.totalPrice = totalPrice;
		this.name = name;
		this.emailId = emailId;
		this.address = address;
		this.createdAt = createdAt;
		this.status = status;
		this.transactionID = transactionID;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", items=" + Arrays.toString(items) + ", totalPrice=" + totalPrice + ", name="
				+ name + ", emailId=" + emailId + ", address=" + address + ", createdAt=" + createdAt + ", status="
				+ status + ", transactionID=" + transactionID + "]";
	}
	
	
	
	

}
