package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	//Finds a customer by their firstname.
	List<Customer> findByFirstName(String firstName);
}
