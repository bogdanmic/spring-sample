package com.gd.spring;

import com.gd.spring.components.HelloBean;
import com.gd.spring.services.ConstantsService;
import com.gd.spring.services.MailClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class PlaygroundApplication {
	private static final Logger logger = LoggerFactory.getLogger(PlaygroundApplication.class);
	public static void main(String[] args) {
		logger.debug("-->START Application!!!");
		ApplicationContext ctx = SpringApplication.run(PlaygroundApplication.class, args);

		logger.info("-->Looking for Spring Bean '{}' in application context.", HelloBean.class);
		// Get a bean from the application context.
		HelloBean bean = ctx.getBean(HelloBean.class);
		logger.info("-->Bean [{}] found.", HelloBean.class.getName());

		logger.warn("-->Using Bean {} to sayHello()", bean.getClass().getName());
		System.out.println(bean.sayHello());
		logger.error("-->Bean sayHello() returned:{}", bean.sayHello());

		logger.info("-->Looking for Spring Bean '{}' in application context.", MailClientService.class);
		// Get a bean from the application context.
		MailClientService mailBean = ctx.getBean(MailClientService.class);
		mailBean.prepareAndSend("sendTo@domain.com", "springboot test");

		logger.info("-->Looking for Spring Bean '{}' in application context.", ConstantsService.class);
		// Get a bean from the application context.
		ConstantsService constantsService = ctx.getBean(ConstantsService.class);
		logger.info("-->The Spring Bean '{}' has these values: {}, {}, {}.", ConstantsService.class,
				constantsService.CONFIG_A, constantsService.CONFIG_B, constantsService.CONFIG_C);

		logger.debug("-->END Application!!!");
	}
}
