package com.example.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_info")
public class Order {
	
									// Primary key generated using the identity strategy
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String orDes;
	
									// One-to-Many relationship with Product entity, with cascade behavior
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Product> products;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, String orDes, List<Product> products) {
		super();
		this.id = id;
		this.orDes = orDes;
		this.products = products;
	}

									//Getters and Setters for each field
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrDes() {
		return orDes;
	}

	public void setOrDes(String orDes) {
		this.orDes = orDes;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
