package com.chen.springeureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chen.springeureka.entity.User;
import com.chen.springeureka.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

	
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-EUREKA-DEMO", false);
	    return instance.getHomePageUrl();
	}
	
	@GetMapping("/simple/{id}")
	public User findOne(@PathVariable Long id) {

		return userRepository.findOne(id);
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		
		@SuppressWarnings("deprecation")
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

}
