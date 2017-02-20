package com.gd.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtApplication {

	/**
	 * Inspired by: https://auth0.com/blog/securing-spring-boot-with-jwts/
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
}
