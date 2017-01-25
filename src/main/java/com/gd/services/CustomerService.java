package com.gd.services;

import com.gd.models.customer.Customer;
import com.gd.models.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by mic on 1/25/17.
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional("customerTransactionManager")
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
}
