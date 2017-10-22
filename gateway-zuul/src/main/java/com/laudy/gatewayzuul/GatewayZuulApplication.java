package com.laudy.gatewayzuul;

import com.laudy.gatewayzuul.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayZuulApplication {

	@Bean
	public PreRequestLogFilter preRequestLogFilter(){
		return new PreRequestLogFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulApplication.class, args);
	}
}
