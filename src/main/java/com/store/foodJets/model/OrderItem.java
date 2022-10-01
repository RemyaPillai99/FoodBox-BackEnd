package com.store.foodJets.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "placedOrder_fk")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "foodItem_fk")
	private FoodItem foodItem;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;

	private BigDecimal rate;

	private int quantity;

	private BigDecimal price;

	private String spInstruction;

	// total price -> or can calculate
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long id, Order order, FoodItem foodItem, User user, BigDecimal rate, int quantity,
			BigDecimal price, String spInstruction) {
		super();
		this.id = id;
		this.order = order;
		this.foodItem = foodItem;
		this.user = user;
		this.rate = rate;
		this.quantity = quantity;
		this.price = price;
		this.spInstruction = spInstruction;
	}

	public String getSpInstruction() {
		return spInstruction;
	}

	public void setSpInstruction(String spInstruction) {
		this.spInstruction = spInstruction;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", foodItem=" + foodItem + ", user=" + user + ", rate="
				+ rate + ", quantity=" + quantity + ", price=" + price + ", spInstruction=" + spInstruction + "]";
	}
}
