package com.gd.spring.controllers;

import com.gd.spring.dtos.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/users") /* Maps to all HTTP actions by default (GET,POST,..)*/
    public
    @ResponseBody
    List<UserDTO> getUsers() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO("Richard", "Feynman"));
        users.add(new UserDTO("Marie", "Curie"));
        return users;
    }
}
