package com.store.foodJets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.foodJets.model.Order;
import com.store.foodJets.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
	
	List<OrderItem>findByOrder(Order order);

}
