package com.example.ecomerce.oreder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrederApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrederApplication.class, args);
	}

}
