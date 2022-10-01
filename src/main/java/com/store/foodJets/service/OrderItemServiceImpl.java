package com.store.foodJets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.store.foodJets.model.Order;
import com.store.foodJets.model.OrderItem;
import com.store.foodJets.model.User;
import com.store.foodJets.repository.OrderItemRepository;

@Service(value = "orderItemService")
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public OrderItem getOrderItemById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<OrderItem> getAllOrderItemByUserId(User userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

	@Override
	public List<OrderItem> getAllOrderItemList() {
		return orderItemRepository.findAll(Sort.by(Sort.Direction.ASC, "order_ID"));
	}

}
