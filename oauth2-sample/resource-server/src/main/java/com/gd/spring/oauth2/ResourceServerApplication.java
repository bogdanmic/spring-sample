package com.gd.spring.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class ResourceServerApplication {

	/**
	 * For more info: https://spring.io/guides/tutorials/spring-security-and-angular-js/
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
