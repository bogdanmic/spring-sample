package com.gd.spring.batch.processors;

import com.gd.spring.models.entities.Customer;
import com.gd.spring.models.entities.CustomerBackup;
import com.gd.spring.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomerDataFixingItemProcessor implements ItemProcessor<Long, CustomerBackup> {

    private final CustomerRepository repository;
    private final AtomicLong counter = new AtomicLong();

    private static final Logger log = LoggerFactory.getLogger(CustomerDataFixingItemProcessor.class);

    @Autowired
    public CustomerDataFixingItemProcessor(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerBackup process(Long customerId) throws Exception {

        Customer customer = repository.findOne(customerId);
        if (customer != null) {
            CustomerBackup result = new CustomerBackup();
            String firstName = customer.getFirstName().replace("- TMP", "").trim();
            String lastName = customer.getLastName().replace("- TMP", "").trim();
            result.setFirstName(firstName);
            result.setLastName(lastName);
            result.setId(customer.getId());

            log.info("Fixed: (" + customer + ")   ----  {}", counter.incrementAndGet());
            return result;
        }
        return null;
    }

}