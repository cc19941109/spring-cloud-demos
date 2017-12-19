package com.motherboard.cilentDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Value("${name:chen}")
	private String name;
	
//	@Autowired
//	private PrefixPros prefixConfig;
	
//	@Autowired
//	private ServerPros serverPros;
	
	@GetMapping("/hello")
	public String hello(){
		return "hello "+name+"\n";
	}
	
	@GetMapping("/info")
	public String info(){
		
		
		return "info: ";
	}
}
