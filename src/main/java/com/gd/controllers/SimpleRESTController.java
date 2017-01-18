package com.gd.controllers;

import com.gd.dto.GreetingDTO;
import com.gd.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mic on 1/18/17.
 */
@RestController
public class SimpleRESTController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingService greetingService;

    @Autowired
    public SimpleRESTController(GreetingService greetingService) {
        // Here we have a constructor Spring Bean injection.
        this.greetingService = greetingService;
    }

    @RequestMapping("/greeting")
    public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingDTO(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    GreetingDTO sayHello(@PathVariable("name") String name) {
        return greetingService.getGreeting(name);
    }
}
