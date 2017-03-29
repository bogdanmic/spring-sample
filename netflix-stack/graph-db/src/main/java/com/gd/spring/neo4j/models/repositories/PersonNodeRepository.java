package com.gd.spring.neo4j.models.repositories;

import com.gd.spring.neo4j.models.entities.PersonNode;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNodeRepository extends GraphRepository<PersonNode> {

    PersonNode findByName(String name);
}