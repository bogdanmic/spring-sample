package com.gd.controllers;

import com.gd.models.Customer;
import com.gd.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CRUDController {
    private final CustomerRepository repository;

    @Autowired
    public CRUDController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/save")
    public String process() {
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }

    @RequestMapping("/findall")
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/findbyid/{id}")
    public Customer findById(@PathVariable("id") long id) {
        return repository.findOne(id);
    }

    @RequestMapping("/findbylastname/{lastname}")
    public List<Customer> fetchDataByLastName(@PathVariable("lastname") String lastName) {
        return repository.findByLastName(lastName);
    }
}
