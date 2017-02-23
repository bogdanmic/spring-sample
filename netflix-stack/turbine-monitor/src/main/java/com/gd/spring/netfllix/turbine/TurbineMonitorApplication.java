package com.gd.spring.netfllix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
@EnableHystrixDashboard
public class TurbineMonitorApplication {

	/**
	 * When accessing the hystrix dashboard enabled on this app, when asked what stream to watch, input this:
	 * http://localhost:8765/turbine.stream?cluster=HYSTRIX-CIRCUIT-BREAKER
	 * where HYSTRIX-CIRCUIT-BREAKER is service name (cluster of services) configured in application.yml
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TurbineMonitorApplication.class, args);
	}
}
