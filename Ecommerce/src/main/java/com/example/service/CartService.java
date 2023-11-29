package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Cart;
import com.example.model.Customer;
import com.example.model.Product;
import com.example.repo.CartRepo;
import com.example.repo.CustomerRepo;
import com.example.repo.ProductRepo;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepository;

    @Autowired
    private CustomerRepo customerRepository;
   
    @Autowired
    private ProductRepo productRepository;


    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }
 
    public Cart getCartById(int id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));
    }

    public Cart saveCart(Cart cart) {
        // Save the associated customer first
        Customer savedCustomer = customerRepository.save(cart.getCustomer());
        // Set the saved customer in the cart
        cart.setCustomer(savedCustomer);

        // Save the associated products
        List<Product> savedProducts = productRepository.saveAll(cart.getProducts());
        // Set the saved products in the cart
        cart.setProducts(savedProducts);
        // Save the cart
        return cartRepository.save(cart);
    }

    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
