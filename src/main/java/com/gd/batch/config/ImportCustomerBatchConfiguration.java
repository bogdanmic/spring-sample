package com.gd.batch.config;


import com.gd.batch.listeners.ImportCustomerJobCompletionNotificationListener;
import com.gd.batch.processors.CsvCustomerItemProcessor;
import com.gd.models.entities.Customer;
import com.gd.repositories.CustomerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class ImportCustomerBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    @Autowired
    public CustomerRepository repository;

    @Autowired
    public CsvCustomerItemProcessor csvUserItemProcessor;

//    @Bean
    // This is a reader that reads from a CSV file.
    public FlatFileItemReader<Customer> csvReader() {
        FlatFileItemReader<Customer> reader = new FlatFileItemReader<Customer>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<Customer>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"firstName", "lastName"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
                setTargetType(Customer.class);
            }});
        }});
        return reader;
    }

    //    @Bean
    // Saves all the Customer objects created/changed in the database.
    public RepositoryItemWriter<Customer> databaseWriter() {
        RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<Customer>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(ImportCustomerJobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

//    @Bean
    // Import users from a CSV file into the database.
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Customer, Customer>chunk(10)
                .reader(csvReader())
                .processor(csvUserItemProcessor)
                .writer(databaseWriter())
                .build();
    }
    // end::jobstep[]
}
