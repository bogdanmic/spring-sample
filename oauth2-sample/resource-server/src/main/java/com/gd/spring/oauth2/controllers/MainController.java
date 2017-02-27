package com.gd.spring.oauth2.controllers;

import com.gd.spring.oauth2.dto.MessageDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @RequestMapping("/")
    @CrossOrigin(origins = "*", maxAge = 3600,
            allowedHeaders={"x-auth-token", "x-requested-with"})
    public MessageDTO home() {
        // In case the @CrossOrigin annotation doesn't work, take a look at: http://stackoverflow.com/questions/32319396/cors-with-spring-boot-and-angularjs-not-working
        return new MessageDTO("Hello World");
    }
}
