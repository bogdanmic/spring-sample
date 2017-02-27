package com.gd.spring.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableOAuth2Sso
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
