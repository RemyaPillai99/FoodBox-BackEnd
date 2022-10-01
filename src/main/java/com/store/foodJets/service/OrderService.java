package com.store.foodJets.service;

import java.util.List;

import com.store.foodJets.model.Order;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public List<Order>getAllOrderByUserId(Long userId);
	
	public Order saveOrder(Order order);
	
	

}
