package com.gd.repository;

import com.gd.dto.GreetingDTO;
import org.springframework.stereotype.Repository;

/**
 * Created by mic on 1/18/17.
 */
@Repository
public class GreetingRepositoryImpl implements GreetingRepository {
    @Override
    public GreetingDTO getGreeting(Long id, String content) {
        // Here we have a Greeting repository that implements the GreetingRepository interface.
        return new GreetingDTO(id, content);
    }
}
