package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.model.Product;
import com.example.repo.OrderRepo;

@Service
public class OrderService {

 @Autowired
 private OrderRepo orderRepo;

 public Order createOrder(Order order) {
	 								// Get the list of products associated with the order
     List<Product> products = order.getProducts();
     								// If there are products associated with the order, set the order for each product
     if (products != null) {
         for (Product product : products) {
        	 	product.setOrder(order);
         }
     }

     								// Save the order with associated products
     return orderRepo.save(order);
 }
}
