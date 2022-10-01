package com.store.foodJets.service;

import java.util.List;

import com.store.foodJets.model.Category;

public interface CategoryService {
	public Category getCategoryById(Long id);
	public Category updateCategory(Category category);
	
	public Category saveCategory(Category category);
	public void deleteCategory(Long id) ;
	public List<Category> fetchProductCategoryList();
	public List<Category> searchCategorybyKeyword(String keyword);
	 

}
