package com.gd.controllers;

import com.gd.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {
    private final PhoneService phoneService;

    @Autowired
    public ThymeleafController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(value = "/mvc", method = RequestMethod.GET)
    public String listPhones(Model model) {
        model.addAttribute("phones", phoneService.listPhones());
        return "phones";
    }
}
