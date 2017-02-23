package com.gd.spring.netflix.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignRestCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignRestCallApplication.class, args);
	}
}
