package com.gd.spring.oauth2.controllers;

import com.gd.spring.oauth2.dto.ChangeDTO;
import com.gd.spring.oauth2.dto.MessageDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    private String message = "Hello World";
    private List<ChangeDTO> changes = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public MessageDTO home() {
        return new MessageDTO(message);
    }

    @RequestMapping(value = "/changes", method = RequestMethod.GET)
    public List<ChangeDTO> changes() {
        return changes;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public MessageDTO update(@RequestBody MessageDTO map, Principal principal) {
        if (map.getContent() != null) {
            message = map.getContent();
            changes.add(new ChangeDTO(principal.getName(), message));
            while (changes.size() > 10) {
                changes.remove(0);
            }
        }
        return new MessageDTO(message);
    }
}
