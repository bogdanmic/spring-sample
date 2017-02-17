package com.gd.spring.repositories;

import com.gd.spring.dto.GreetingDTO;
import org.springframework.stereotype.Repository;


@Repository
public class GreetingRepositoryImpl implements GreetingRepository {
    @Override
    public GreetingDTO getGreeting(Long id, String content) {
        // Here we have a Greeting repository that implements the GreetingRepository interface.
        return new GreetingDTO(id, content);
    }
}
