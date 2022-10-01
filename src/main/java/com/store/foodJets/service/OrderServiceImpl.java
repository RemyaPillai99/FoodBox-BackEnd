package com.store.foodJets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.foodJets.model.Order;
import com.store.foodJets.repository.OrderRepository;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getAllOrderByUserId(Long userId) {
		
		return null;
	}

	@Override
	public Order saveOrder(Order order) {
		
		return orderRepository.save(order);
	}

}
