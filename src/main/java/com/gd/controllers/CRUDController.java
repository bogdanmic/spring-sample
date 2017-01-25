package com.gd.controllers;

import com.gd.models.entities.Customer;
import com.gd.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @RequestMapping("/findbyfirstName/{firstName}")
    public List<Customer> fetchDataByFirstName(@PathVariable("firstName") String firstName) {
        return repository.findByFirstNameIgnoreCase(firstName);
    }

    @RequestMapping("/findbylastname2/{lastName}")
    public List<Customer> fetchDataByLastName2(@PathVariable("lastName") String lastName) {
        return repository.findByLastNameOrderByFirstNameAsc(lastName);
    }

    @RequestMapping("/findbylastname3/{lastName}")
    public List<Object[]> fetchDataByLastName3(@PathVariable("lastName") String lastName) {
        return repository.findByAsArrayAndSort(lastName, new Sort("fn_len"));
    }
}
