package com.store.foodJets.service;

import java.util.List;

import com.store.foodJets.model.Category;
import com.store.foodJets.model.FoodItem;

public interface FoodItemService {
	
	public FoodItem getFoodItemById(Long itemCode);
	
	public FoodItem getFoodItemByCategory(Category FoodItemCategory);
	
	public FoodItem updateFoodItem(FoodItem FoodItem);
	
	public FoodItem saveFoodItem(FoodItem FoodItem);
	public void deleteFoodItem(Long itemCode);
	
	
	public List<FoodItem> getAllFoodItems();

	public List<FoodItem> searchFoodItemByKeyword(String keyword);

}
