package com.laudy.dcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcServiceApplication.class, args);
	}
}
