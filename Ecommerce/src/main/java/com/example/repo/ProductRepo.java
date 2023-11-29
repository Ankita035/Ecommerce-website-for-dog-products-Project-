package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	//Finds a product by their Name.
		Optional<Product> findById(Long id);
}
