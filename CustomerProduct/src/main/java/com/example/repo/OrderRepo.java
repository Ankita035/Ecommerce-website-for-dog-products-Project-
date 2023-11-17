package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

	//Finds a order by their ID.
	Optional<Order> findById(Long id);
}
