package com.gd.controllers;

import com.gd.models.customer.Customer;
import com.gd.models.entities.Phone;
import com.gd.services.CustomerService;
import com.gd.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<Customer> list() {
        return service.findAll();
    }

}
