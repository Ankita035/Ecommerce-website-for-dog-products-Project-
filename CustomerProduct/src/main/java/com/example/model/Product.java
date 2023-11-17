package com.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product_info")
public class Product {

									// Primary key generated using the identity strategy
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;				//defining variables
	
	private String name;
	
	private String price;

									// Many-to-One relationship with Customer entity
	 @ManyToOne
	 @JoinColumn(name = "customer_id") 
	 private Customer customer;
	
	 								// Many-to-One relationship with Order entity, with cascade behavior
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "order_id")	
	 private Order order;

	 
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String price, Customer customer, Order order) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.customer = customer;
		this.order = order;
	}
						
									//Getters and Setters for each field
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


}
