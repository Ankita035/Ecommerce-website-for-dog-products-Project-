package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	//Finds a customer by their Id.
		Optional<Customer> findById(Long id);
}
