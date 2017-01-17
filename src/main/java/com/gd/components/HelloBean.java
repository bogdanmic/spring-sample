package com.gd.components;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

    public String sayHello() {
        return "Hello World!";
    }
}
