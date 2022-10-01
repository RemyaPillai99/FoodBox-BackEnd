package com.store.foodJets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.foodJets.exception.ResourceNotFoundException;
import com.store.foodJets.model.Category;
import com.store.foodJets.repository.CategoryRepository;

@Service(value ="categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category getCategoryById(Long id) {
		 return categoryRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Category updateCategory(Category category) {
		
		/*
		 * if(categoryRepository.findById(category.getId()).) throw new
		 * ResourceNotFoundException("Category", "Id", category.getId());
		 * 
		 * else
		 */
		Category existingCategory = categoryRepository.findById(category.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", category.getId())); 
		
			return categoryRepository.save(category);
	}

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> fetchProductCategoryList() {
		
		return (List<Category>)categoryRepository.findAll();
	}
	
	@Override
	public List<Category> searchCategorybyKeyword(String keyword) {
		
		return categoryRepository.searchCategory(keyword);
	}


}
