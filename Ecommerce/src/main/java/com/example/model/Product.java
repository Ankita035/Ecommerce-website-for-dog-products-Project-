package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Product(Long id, String name, String price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

									//Getters and Setters for each field
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
