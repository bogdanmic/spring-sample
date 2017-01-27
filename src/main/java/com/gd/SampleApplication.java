package com.gd;

import com.gd.components.HelloBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class SampleApplication {

    private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);

    public static void main(String[] args) {
        logger.debug("-->START Application!!!");
        ApplicationContext ctx = SpringApplication.run(SampleApplication.class, args);

        logger.info("-->Looking for Spring Bean '{}' in application context.", HelloBean.class);
        // Get a bean from the application context.
        HelloBean bean = ctx.getBean(HelloBean.class);
        logger.info("-->Bean [{}] found.", HelloBean.class.getName());

        logger.warn("-->Using Bean {} to sayHello()", bean.getClass().getName());
        System.out.println(bean.sayHello());
        logger.error("-->Bean sayHello() returned:{}", bean.sayHello());

        logger.debug("-->END Application!!!");
    }
}
