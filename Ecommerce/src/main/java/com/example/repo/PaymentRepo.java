package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	
	//Finds a user by their Id. 
	Optional<Payment>findById(int id);
}
