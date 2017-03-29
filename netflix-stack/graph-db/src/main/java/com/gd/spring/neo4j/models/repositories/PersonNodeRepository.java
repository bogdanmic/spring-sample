package com.gd.spring.neo4j.models.repositories;

import com.gd.spring.neo4j.models.entities.PersonNode;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNodeRepository extends GraphRepository<PersonNode> {

    /**
     * More info at: http://docs.spring.io/spring-data/data-neo4j/docs/4.2.1.RELEASE/reference/html/
     * @param name
     * @return
     */
    PersonNode findByName(String name);
}