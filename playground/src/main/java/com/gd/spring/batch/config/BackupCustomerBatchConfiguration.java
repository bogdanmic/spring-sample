package com.gd.spring.batch.config;


import com.gd.spring.batch.listeners.ImportCustomerJobCompletionNotificationListener;
import com.gd.spring.batch.processors.CustomerDataFixingItemProcessor;
import com.gd.spring.models.entities.CustomerBackup;
import com.gd.spring.repositories.CustomerBackupRepository;
import com.gd.spring.repositories.CustomerPagerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BackupCustomerBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Autowired
    public CustomerPagerRepository customerPagerRepository;

    @Autowired
    public CustomerBackupRepository customerBackupRepository;


    @Autowired
    public CustomerDataFixingItemProcessor customerDataFixingItemProcessor;



    // This reads from a database using a repository with a custom method with params.
    public RepositoryItemReader<Long> databaseReader() {
        RepositoryItemReader<Long> reader = new RepositoryItemReader<Long>();
        reader.setRepository(customerPagerRepository);
        reader.setPageSize(100);
        Map<String, Sort.Direction> sort = new HashMap<>();
        sort.put("id", Sort.Direction.ASC);
        reader.setSort(sort);
        reader.setMaxItemCount(20000);

        List<String> parameters = new ArrayList<String>();
        String param = "- TMP";
        parameters.add(param);
        reader.setArguments(parameters);
        reader.setMethodName("customMethod");


        return reader;
    }

    //    @Bean
    // Saves all the Customer objects created/changed in the database.
    public RepositoryItemWriter<CustomerBackup> databaseWriter() {
        RepositoryItemWriter<CustomerBackup> writer = new RepositoryItemWriter<CustomerBackup>();
        writer.setRepository(customerBackupRepository);
        writer.setMethodName("save");
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job backupUserJob(ImportCustomerJobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("backupUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1())
                .build();
    }

    // Fix some user data if needed.
    // Since we use the same table to change some data. SOme  data gets skipped for some reason.
    // This reason might be because of table/row level locks that the database places on the rows we read.
    // So to process all the data, we copy it from one table into another. Based on certain conditions of course.
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Long, CustomerBackup>chunk(1000)
                .reader(databaseReader())
                .processor(customerDataFixingItemProcessor)
                .writer(databaseWriter())
                .build();
    }
    // end::jobstep[]
}
