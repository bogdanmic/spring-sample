package com.gd.controllers;

import com.gd.models.order.Order;
import com.gd.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Iterable<Order> list() {
        return service.findAll();
    }

}
