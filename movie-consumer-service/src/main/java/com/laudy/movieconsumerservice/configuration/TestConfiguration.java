package com.laudy.movieconsumerservice.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="simple-user-service", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
