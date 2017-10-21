package com.laudy.movieconsumerfeignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class MovieConsumerFeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieConsumerFeignServiceApplication.class, args);
	}
}
