package com.gd.spring.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GraphDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphDbApplication.class, args);
	}
}
