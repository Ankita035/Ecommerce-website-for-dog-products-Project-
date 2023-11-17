package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	//Finds a product by their Name.
	List<Product> findByName(String name);
}
