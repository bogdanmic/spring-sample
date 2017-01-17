package com.gd;

import com.gd.components.HelloBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SampleApplication.class, args);

        // Get a bean from the application context.
        HelloBean bean = ctx.getBean(HelloBean.class);
        System.out.println(bean.sayHello());

    }
}
