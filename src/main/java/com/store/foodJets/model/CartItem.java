package com.store.foodJets.model;

import java.math.BigDecimal;

//pojo class
public class CartItem {

	private FoodItem foodItem;
	private int quantity;
	private BigDecimal price; // total
	private String spInstruction; // need to add

	public CartItem() {
	}

	public CartItem(FoodItem foodItem, int quantity, BigDecimal price, String spInstruction) {
		super();
		this.foodItem = foodItem;
		this.quantity = quantity;
		this.price = price;
		this.spInstruction = spInstruction;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSpInstruction() {
		return spInstruction;
	}

	public void setSpInstruction(String spInstruction) {
		this.spInstruction = spInstruction;
	}

}
