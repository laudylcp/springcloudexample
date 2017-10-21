package com.laudy.movieconsumerservice.controller;

import com.laudy.movieconsumerservice.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://simple-user-service/" + id, User.class);
    }

    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("simple-user-service");
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("simple-user-service");
        MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

}
