package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Order;
import com.example.repo.OrderRepo;
import com.example.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private OrderService orderService;

    							//Get a list of all Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    							//Get an order by Id.
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return ResponseEntity.ok(order);
    }

    							//Create an Order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Assuming you have a service method to handle order creation
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    							//Update a existing order by Id.
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        //Update an Order Details
        order.setOrDes(orderDetails.getOrDes());
        order.setProducts(orderDetails.getProducts());

        Order updatedOrder = orderRepo.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    							//Delete an Order by Id.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        orderRepo.delete(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

