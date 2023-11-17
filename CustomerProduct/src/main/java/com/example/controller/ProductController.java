package com.example.controller;

import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import com.example.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    							//Get a list of products 
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    							//Get a product by Id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return ResponseEntity.ok(product);
    }

    							//Create a product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productRepo.save(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    							//Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        						//Updating a products details
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCustomer(productDetails.getCustomer());

        Product updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    							//Delete a product by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        productRepo.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}