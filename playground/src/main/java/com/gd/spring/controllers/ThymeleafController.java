package com.gd.spring.controllers;

import com.gd.spring.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ThymeleafController {
    private final PhoneService phoneService;

    @Autowired
    public ThymeleafController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/mvc", method = RequestMethod.GET)
    public String listPhones(Model model) {
        model.addAttribute("phones", phoneService.listPhones());
        return "phones";
    }

    @RequestMapping("/mvc/phone/{id}")
    public String editPhone(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", phoneService.getPhoneById(id));
        return "phone";
    }

    @RequestMapping("/websoket-client")
    public String websoketClient(Model model) {
        return "websoket-client";
    }
}
