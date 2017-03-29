package com.gd.spring.neo4j.components;


import com.gd.spring.neo4j.models.entities.PersonNode;
import com.gd.spring.neo4j.models.repositories.PersonNodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Neo4jSampleRunner implements CommandLineRunner {


    private final PersonNodeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        PersonNode greg = new PersonNode("Greg");
        PersonNode roy = new PersonNode("Roy");
        PersonNode craig = new PersonNode("Craig");
        PersonNode bob = new PersonNode("Bob");
        PersonNode joe = new PersonNode("Joe");
        PersonNode tom = new PersonNode("Tom");

        List<PersonNode> team = Arrays.asList(greg, roy, craig, bob, joe, tom);

        log.info("Before linking up with Neo4j...");

        team.stream().forEach(person -> log.info("\t" + person.toString()));

        repository.save(greg);
        repository.save(roy);
        repository.save(craig);
        repository.save(bob);
        repository.save(joe);
        repository.save(tom);

        greg = repository.findByName(greg.getName());
        greg.worksWith(roy);
        greg.worksWith(craig);
        greg.worksWith(joe);
        repository.save(greg);

        roy = repository.findByName(roy.getName());
        roy.worksWith(craig);
        roy.worksWith(tom);
        roy.worksWith(bob);
        // We already know that roy works with greg
        repository.save(roy);

        // We already know craig works with roy and greg

        log.info("Lookup each person by name...");
        team.stream().forEach(person -> log.info(
                "\t" + repository.findByName(person.getName()).toString()));
    }

}
