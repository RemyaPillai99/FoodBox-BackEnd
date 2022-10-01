package com.store.foodJets.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.foodJets.model.CartItem;
import com.store.foodJets.model.Category;
import com.store.foodJets.model.FoodItem;
import com.store.foodJets.model.Order;
import com.store.foodJets.model.OrderDTO;
import com.store.foodJets.model.OrderItem;
import com.store.foodJets.model.User;
import com.store.foodJets.repository.CategoryRepository;
import com.store.foodJets.repository.FoodItemRepository;
import com.store.foodJets.repository.OrderItemRepository;
import com.store.foodJets.repository.OrderRepository;
import com.store.foodJets.service.OrderItemService;
import com.store.foodJets.service.OrderService;
import com.store.foodJets.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShopController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FoodItemRepository foodItemRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@GetMapping("/shop")
	public List<FoodItem> getAllFoodItemAvail() {
		System.out.println("##ALL" + foodItemRepository.findByitemAvailTag(true).toString());
		return foodItemRepository.findByitemAvailTag(true);

	}

	@GetMapping("/popular")
	public List<FoodItem> getAllFoodItemPopular() {
		return foodItemRepository.findBypopularTagAndItemAvailTag(true, true);

	}

	@GetMapping("/shop/cuisine/{cuisineName}")
	public List<FoodItem> shopByCuisine(@PathVariable String cuisineName) {
		Category selectedCategory = categoryRepository.findByCategoryName(cuisineName);
		return foodItemRepository.findByCategoryAndItemAvailTag(selectedCategory, true);
	}

	// save order and order item details

	@PostMapping("shop/pay")
	public ResponseEntity<Map<String, Boolean>> placeOrder(@RequestBody OrderDTO orderDTO) {

		System.out.println(orderDTO.getEmailId() + "Email");

		User user = userService.getUser(orderDTO.getEmailId());

		Order order = new Order();

		order.setUser(user);
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setStatus("Order Confirmed");
		long now = System.currentTimeMillis();
		java.sql.Timestamp sqlTimestamp = new Timestamp(now);
		System.out.println(sqlTimestamp);
		order.setCreatedAt(sqlTimestamp);
		order.setAddress(orderDTO.getAddress());
		orderService.saveOrder(order);
		System.out.println("############### After Save " + order.toString());

		CartItem[] cartItems = orderDTO.getItems();

		for (CartItem item : cartItems) {
			OrderItem orderItem = new OrderItem();
			orderItem.setFoodItem(item.getFoodItem());
			orderItem.setOrder(order);
			orderItem.setPrice(item.getPrice());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setRate(item.getFoodItem().getPrice());
			orderItem.setUser(user);

			orderItemService.saveOrderItem(orderItem);

		}

		Map<String, Boolean> map = new HashMap<>();
		map.put("created", Boolean.TRUE);
		return ResponseEntity.ok(map);
	}

	@GetMapping("shop/orderSummary/{emailId}")
	public OrderDTO findLatestOrder(@PathVariable String emailId) {

		User user = userService.getUser(emailId);
		Order order = orderRepository.findFirstByUserAndStatusOrderByIDDesc(userService.getUser(emailId),
				"Order Confirmed");
		System.out.println(order.toString());

		List<OrderItem> orderItemList = orderItemRepository.findByOrder(order);
		System.out.println(orderItemList);
		List<CartItem> cartItemsList = new ArrayList<>();
		for (OrderItem orderItem : orderItemList) {
			CartItem cartItem = new CartItem();
			cartItem.setFoodItem(orderItem.getFoodItem());
			cartItem.setPrice(orderItem.getPrice());
			cartItem.setQuantity(orderItem.getQuantity());
			cartItem.setSpInstruction(orderItem.getSpInstruction());

			cartItemsList.add(cartItem);

		}
		CartItem[] cartItems = cartItemsList.toArray(new CartItem[0]);
		OrderDTO orderDto = new OrderDTO();
		orderDto.setAddress(order.getAddress());
		orderDto.setCreatedAt(order.getCreatedAt());
		orderDto.setEmailId(emailId);
		orderDto.setId(order.getID());
		orderDto.setItems(cartItems);
		orderDto.setName(user.getFirstName());
		orderDto.setStatus(order.getStatus());
		orderDto.setTotalPrice(order.getTotalPrice());
		return orderDto;
	}

}
