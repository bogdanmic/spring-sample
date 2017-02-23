package com.gd.spring.netflix.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
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
