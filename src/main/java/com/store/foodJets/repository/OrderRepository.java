package com.store.foodJets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.foodJets.model.Order;
import com.store.foodJets.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserAndStatus(User user, String status);

	Order findFirstByUserAndStatus(User user, String status);

	Order findFirstByUserAndStatusOrderByIDDesc(User user, String status);

}
