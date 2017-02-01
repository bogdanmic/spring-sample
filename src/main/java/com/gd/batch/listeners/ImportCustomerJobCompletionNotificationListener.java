package com.gd.batch.listeners;


import com.gd.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportCustomerJobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(ImportCustomerJobCompletionNotificationListener.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public ImportCustomerJobCompletionNotificationListener(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            log.info("!!! JOB FINISHED! Customers in the db = {}", customerRepository.count());
            // Here we can do our verification logic.
        }
    }
}
