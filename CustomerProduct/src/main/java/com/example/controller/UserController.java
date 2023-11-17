package com.example.controller;

import com.example.exception.ResourceNotFoundException; 
import com.example.model.User; 
import com.example.repo.UserRepo; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/users") 
public class UserController {

	@Autowired
	private UserRepo userRepo;

								//Get a list of all users.
	@GetMapping
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

								//Get a user by ID.
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return ResponseEntity.ok(user);
	}

								//Create a new user.
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userRepo.save(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

								//Update an existing user by Id.
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		// Update user details
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}

								//Delete a user by ID.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		userRepo.delete(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
} 