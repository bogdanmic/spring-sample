package com.gd.spring.cloud.config.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    /**
     * If we do a POST to this application's '/refresh' endpoint, this value will be refreshed from the config server.
     * Or we can use spring boot admin.
     */
    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
