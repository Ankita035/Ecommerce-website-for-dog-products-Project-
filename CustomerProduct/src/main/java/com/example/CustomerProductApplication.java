package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CustomerProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProductApplication.class, args);
	}

}
