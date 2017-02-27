package com.gd.spring.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SinglePageAppApplication {
	/**
	 * For more info: https://spring.io/guides/tutorials/spring-security-and-angular-js/
	 * For this app we need to run redis locally. We can do this with docker like this: docker run --name some-redis -d redis
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SinglePageAppApplication.class, args);
	}
}
