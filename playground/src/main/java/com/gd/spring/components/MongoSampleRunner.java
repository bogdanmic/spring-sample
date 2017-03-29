package com.gd.spring.components;


import com.gd.spring.models.mongo.SimplePojo;
import com.gd.spring.repositories.SimplePojoMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MongoSampleRunner implements CommandLineRunner {


    private final SimplePojoMongoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new SimplePojo("Alice", "Smith"));
        repository.save(new SimplePojo("Bob", "Smith"));
        repository.save(new SimplePojo("Bob", "Doe"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (SimplePojo customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (SimplePojo customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        System.out.println("Customers found with findByThePersonsFirstname('Bob'):");
        System.out.println("--------------------------------");
        for (SimplePojo customer : repository.findByThePersonsFirstname("Bob")) {
            System.out.println(customer);
        }
    }

}
