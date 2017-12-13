package com.chen.springconsumermovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chen.springconsumermovie.entity.User;


@RestController
public class MovieController {

	@Value("user.servicepath")
	private String userServicePath;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		return restTemplate.getForObject(userServicePath+id, User.class);
	}
	
}
