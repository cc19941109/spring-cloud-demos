package com.chen.springcloudconfigdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SpringcloudConfigDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigDemo2Application.class, args);
	}
}
