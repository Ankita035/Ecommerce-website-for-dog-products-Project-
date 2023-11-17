package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Customer;
import com.example.repo.CustomerRepo;
import com.example.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private CustomerService customerService;
    
    						//Get a list of all customers 
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    						//Get a customer by ID.
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return ResponseEntity.ok(customer);
    }

    						//Create a customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.createCustomer(customer);
            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            				// Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    						//Update an existing customer by Id
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        					//Update customer details
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmailId(customerDetails.getEmailId());
        customer.setProducts(customerDetails.getProducts());

        Customer updatedCustomer = customerRepo.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    						//Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customerRepo.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
