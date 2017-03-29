package com.gd.spring.repositories;

import com.gd.spring.models.mongo.SimplePojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimplePojoMongoRepository extends MongoRepository<SimplePojo, String> {
    SimplePojo findByFirstName(String firstName);

    List<SimplePojo> findByLastName(String lastName);

    /**
     * More info at: http://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html
     *
     * @param firstname
     * @return
     */
    @Query(value = "{ 'firstName' : ?0 }", fields = "{ 'firstName' : 1}")
    List<SimplePojo> findByThePersonsFirstname(String firstname);
}
