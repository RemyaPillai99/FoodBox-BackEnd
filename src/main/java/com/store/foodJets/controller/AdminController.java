package com.store.foodJets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.foodJets.model.Admin;
import com.store.foodJets.model.Category;
import com.store.foodJets.model.FoodItem;
import com.store.foodJets.model.OrderItem;
import com.store.foodJets.repository.AdminRepository;
import com.store.foodJets.service.CategoryService;
import com.store.foodJets.service.FoodItemService;
import com.store.foodJets.service.OrderItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FoodItemService foodItemService;
	
	@Autowired
	private OrderItemService orderItemSrevice;

	@PostMapping(path = "/admins") // Request body --> json data
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {

		Admin saveAdmin = adminRepository.save(admin);

		if (saveAdmin != null)
			return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
		else
			return new ResponseEntity<Admin>(admin, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// login
	@PostMapping("/admin-login")
	public ResponseEntity<Admin> verifyLogin(@RequestBody Admin admin) {

		Admin userDB = adminRepository.findByEmailIdAndPassword(admin.getEmailId(), admin.getPassword());

		if (userDB != null)
			return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
		else
			return new ResponseEntity<Admin>(admin, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// ## Cuisines

	// list
	@GetMapping("admin/category")
	public List<Category> getAllCategory() {
		return categoryService.fetchProductCategoryList();

	}

	// add
	@PostMapping("/admin/category/Add")
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);
	}

	// Get by Id
	@GetMapping(path = "/admin/category/{Id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("Id") Long categoryId) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}

	// Edit Category

	@PutMapping(path = "/admin/category/Edit")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.OK);
	}
	
	// Delete

	@DeleteMapping(path = "/admin/category/Delete/{Id}")
	public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable("Id") Long categoryId) {

		categoryService.deleteCategory(categoryId);
		Map<String, Boolean> map = new HashMap<>();
		map.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(map);

	}

	// search by keyword

	@GetMapping("/admin/category/search/{keyword}")
	public List<Category> searchCategory(@PathVariable String keyword) {
		return categoryService.searchCategorybyKeyword(keyword);
	}

	// FoodItem

	// add
	@PostMapping("/admin/foodItem/Add")
	public ResponseEntity<FoodItem> createFoodItem(@Valid @RequestBody FoodItem foodItem) {
		return new ResponseEntity<FoodItem>(foodItemService.saveFoodItem(foodItem), HttpStatus.CREATED);
	}

	// Edit FoodItem

	@PutMapping(path = "/admin/foodItem/Edit")
	public ResponseEntity<FoodItem> updateFooditem(@RequestBody FoodItem foodItem) {
		return new ResponseEntity<FoodItem>(foodItemService.updateFoodItem(foodItem), HttpStatus.OK);
	}

	// Delete

	@DeleteMapping(path = "/admin/foodItem/Delete/{Id}")
	public ResponseEntity<Map<String, Boolean>> deleteFoodItem(@PathVariable("Id") Long itemCode) {

		foodItemService.deleteFoodItem(itemCode);
		Map<String, Boolean> map = new HashMap<>();
		map.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(map);

	}

	// list
	@GetMapping("admin/foodItem")
	public List<FoodItem> getAllFoodItem() {
		return foodItemService.getAllFoodItems();

	}

	// Get by Id
	@GetMapping({ "/admin/foodItem/{Id}", "/food/{Id}" })
	public ResponseEntity<FoodItem> getFoodItemByCode(@PathVariable("Id") Long itemCode) {
		return new ResponseEntity<FoodItem>(foodItemService.getFoodItemById(itemCode), HttpStatus.OK);
	}
	// search by keyword

	@GetMapping({ "/admin/foodItem/search/{keyword}", "/search/{keyword}" })
	public List<FoodItem> searchFooditem(@PathVariable String keyword) {
		return foodItemService.searchFoodItemByKeyword(keyword);
	}

	// list
	@GetMapping("admin/orderReport")
	public List<OrderItem> getAllOrderItemList() {
		return orderItemSrevice.getAllOrderItemList();

	}
}
