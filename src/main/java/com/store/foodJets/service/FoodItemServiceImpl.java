package com.store.foodJets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.foodJets.exception.ResourceNotFoundException;
import com.store.foodJets.model.Category;
import com.store.foodJets.model.FoodItem;
import com.store.foodJets.repository.FoodItemRepository;

@Service(value="foodItemService")
public class FoodItemServiceImpl implements FoodItemService{

	@Autowired
	private FoodItemRepository foodItemRepository;
	@Override
	public FoodItem getFoodItemById(Long itemCode) {
		return foodItemRepository.findById(itemCode).get();
	}

	@Override
	public FoodItem getFoodItemByCategory(Category FoodItemCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem updateFoodItem(FoodItem foodItem) {
		FoodItem existingFoodItem = foodItemRepository.findById(foodItem.getItemCode()).orElseThrow(
				() -> new ResourceNotFoundException("FoodItem", "Id", foodItem.getItemCode())); 
		
			return foodItemRepository.save(foodItem);
	}

	@Override
	public FoodItem saveFoodItem(FoodItem FoodItem) {
		return foodItemRepository.save(FoodItem);
	}

	@Override
	public void deleteFoodItem(Long itemCode) {
		foodItemRepository.deleteById(itemCode);
		
	}

	@Override
	public List<FoodItem> getAllFoodItems() {
		return (List<FoodItem>)foodItemRepository.findAll();
	}

	@Override
	public List<FoodItem> searchFoodItemByKeyword(String keyword) {
		
		return foodItemRepository.searchFoodItem(keyword);
	}

}
