package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.Customer;
import com.example.model.Product;
import com.example.repo.CustomerRepo;

@Service
public class CustomerService {

 @Autowired
 private CustomerRepo customerRepo;

 public Customer createCustomer(Customer customer) {
	 								// Get the list of products associated with the customer
     List<Product> products = customer.getProducts();
     								// If there are products associated with the customer, set the customer for each product
     if (products != null) {
         for (Product product : products) {
        	 						// Set the customer for each product to establish the association
             product.setCustomer(customer);
         }
     }
     								// Save the customer with associated products
     return customerRepo.save(customer);
 }
}
