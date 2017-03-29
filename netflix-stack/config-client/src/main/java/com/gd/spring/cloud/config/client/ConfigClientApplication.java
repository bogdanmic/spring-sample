package com.gd.spring.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {

    /**
     * For more: https://spring.io/guides/gs/centralized-configuration/
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
