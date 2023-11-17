package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repo.CustomerRepo;
import com.example.repo.OrderRepo;
import com.example.repo.ProductRepo;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepo productRepo;

	    @Autowired
	    private CustomerRepo customerRepo;
	    
	    @Autowired
	    private OrderRepo orderRepo; 

	    public Product createProduct(Product product) {
	        
	        Customer customer = product.getCustomer();
	        						// If there are products associated with the customer, set the customer for each product

	        if (customer != null) {
	        						// Get the list of products associated with the customer
	            List<Product> customerProducts = customer.getProducts();
	            customerProducts.add(product);
	            customer.setProducts(customerProducts);
	            					// Save the customer with associated products
	            customerRepo.save(customer);
	        }

	        
	        Order order = product.getOrder();
	        						// If there are products associated with the order, set the order for each product
	        if (order != null) {
	        						// Get the list of products associated with the order
	        	List<Product> orderProducts = order.getProducts();
	            orderProducts.add(product);
	            order.setProducts(orderProducts);
	            					// Save the order with associated products
	            orderRepo.save(order);
	        }

	        								// Save the product along with the associated customer and order
	        return productRepo.save(product);
	    }
}
