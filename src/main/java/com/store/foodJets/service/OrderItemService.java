package com.store.foodJets.service;

import java.util.List;


import com.store.foodJets.model.OrderItem;
import com.store.foodJets.model.User;

public interface OrderItemService {

	public OrderItem getOrderItemById(Long id);

//	public List<OrderItem> getAllItemsByOrderItem(Order order);

	public List<OrderItem> getAllOrderItemByUserId(User userId);

	public OrderItem saveOrderItem(OrderItem orderItem);

	public List<OrderItem> getAllOrderItemList();

}
