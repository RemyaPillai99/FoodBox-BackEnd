package com.store.foodJets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.foodJets.model.Category;
import com.store.foodJets.model.User;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT u FROM Category u WHERE "
			+" u.categoryName LIKE %?1%"
			+" OR u.description LIKE %?1%")
	public List<Category> searchCategory(String keyword);
	
	Category findByCategoryName(String categoryName);
}
