package com.example.ecomerce.e_gateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGatewayApplication.class, args);
	}


	/**
	 * By default, the HttpClient uses Netty’s domain name lookup mechanism that resolves a domain name asynchronously.
	 * This is as an alternative of the JVM’s built-in blocking resolver.
	 * Sometimes, you may want to switch to the JVM built-in resolver.
	 */
	@Bean
	@Primary
	public WebClient webClient() {
		HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.build();
	}
}
