package com.gd.spring.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

	/**
	 * For more: https://spring.io/guides/tutorials/spring-security-and-angular-js/
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
