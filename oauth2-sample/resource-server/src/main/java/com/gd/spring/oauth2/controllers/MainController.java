package com.gd.spring.oauth2.controllers;

import com.gd.spring.oauth2.dto.MessageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/resource")
    public MessageDTO home() {
        return new MessageDTO("Hello World");
    }
}
