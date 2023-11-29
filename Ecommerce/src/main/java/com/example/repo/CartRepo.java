package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

			//Finds a user by their Id. 
	Optional<Cart>findById(int Id);
}
