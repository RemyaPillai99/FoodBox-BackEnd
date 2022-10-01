package com.store.foodJets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.foodJets.model.Category;
import com.store.foodJets.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

	@Query("SELECT u FROM FoodItem u WHERE "
			+" u.itemName LIKE %?1%"
			+" OR u.itemDesc LIKE %?1%")
	public List<FoodItem> searchFoodItem(String keyword);
	
	List<FoodItem>findByCategory(Category category);
	List<FoodItem>findByCategoryAndItemAvailTag(Category category, Boolean itemAvailTag);
	List<FoodItem>findBypopularTagAndItemAvailTag(Boolean popularTag, Boolean itemAvailTag);
	List<FoodItem>findByitemAvailTag(Boolean itemAvailTag);
}
