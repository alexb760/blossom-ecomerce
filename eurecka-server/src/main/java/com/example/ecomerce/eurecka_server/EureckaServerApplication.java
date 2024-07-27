package com.example.ecomerce.eurecka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureckaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureckaServerApplication.class, args);
	}

}
