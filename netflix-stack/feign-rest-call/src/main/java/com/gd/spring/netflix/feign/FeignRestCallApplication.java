package com.gd.spring.netflix.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignRestCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignRestCallApplication.class, args);
	}
}
