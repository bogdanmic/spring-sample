package com.gd.spring.batch.processors;

import com.gd.spring.models.entities.Customer;
import com.gd.spring.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CsvCustomerItemProcessor implements ItemProcessor<Customer, Customer> {

    private static final Logger log = LoggerFactory.getLogger(CsvCustomerItemProcessor.class);

    private final CustomerRepository repository;

    @Autowired
    public CsvCustomerItemProcessor(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer process(final Customer customer) throws Exception {
        // We only import users that we don't have. We use a simple dummy check
        List<Customer> existingRecord = repository.findByFirstNameIgnoreCase(customer.getFirstName());
        if (existingRecord.isEmpty()) {
            // No customer was found
            final String firstName = customer.getFirstName().toUpperCase()+"- TMP";
            final String lastName = customer.getLastName().toUpperCase()+"- TMP";

            final Customer transformedPerson = new Customer(firstName, lastName);

            log.info("Converting (" + customer + ") into (" + transformedPerson + ")");

            return transformedPerson;
        }
        // The customer exists so we return null.
        log.warn("Customer with name like '{}' already exists!({})", customer.getFirstName(), customer);
        return null;
    }

}