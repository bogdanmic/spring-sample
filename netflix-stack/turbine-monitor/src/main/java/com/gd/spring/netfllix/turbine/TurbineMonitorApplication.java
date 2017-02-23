package com.gd.spring.netfllix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TurbineMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineMonitorApplication.class, args);
	}
}
