package com.store.foodJets.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemCode;

	private String itemName;

	private String itemDesc;

	@ManyToOne
	@JoinColumn(name = "foodCategory_fk")
	private Category category;

	private BigDecimal price;

	private BigDecimal discount;

	private String image;

	@Column(columnDefinition = "boolean default false")
	private boolean popularTag;

	@Column(columnDefinition = "boolean default true")
	private boolean itemAvailTag;

	// instock /out of stock - boolean true false

	// calories
	// availability show list that avail = true
	// popular tag show list that avail = true findbyPopular tag

	public String getImage() {
		return image;
	}

	public boolean isPopularTag() {
		return popularTag;
	}

	public void setPopularTag(boolean popularTag) {
		this.popularTag = popularTag;
	}

	public boolean isitemAvailTag() {
		return itemAvailTag;
	}

	public void setitemAvailTag(boolean itemAvailTag) {
		this.itemAvailTag = itemAvailTag;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getItemCode() {
		return itemCode;
	}

	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public FoodItem() {

	}

	public FoodItem(Long itemCode, String itemName, String itemDesc, Category category, BigDecimal price,
			BigDecimal discount, String image, boolean popularTag, boolean itemAvailTag) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.image = image;
		this.popularTag = popularTag;
		this.itemAvailTag = itemAvailTag;
	}

	@Override
	public String toString() {
		return "FoodItem [itemCode=" + itemCode + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", category="
				+ category + ", price=" + price + ", discount=" + discount + ", image=" + image + ", popularTag="
				+ popularTag + ", itemAvailTag=" + itemAvailTag + "]";
	}

}
