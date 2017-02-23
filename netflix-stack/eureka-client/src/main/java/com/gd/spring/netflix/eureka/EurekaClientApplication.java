package com.gd.spring.netflix.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

    /**
     * See more at: https://blog.de-swaef.eu/the-netflix-stack-using-spring-boot-part-3-feign/
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
