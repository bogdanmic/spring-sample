package com.gd.spring.repositories;


import com.gd.spring.dto.GreetingDTO;

/**
 * Created by mic on 1/18/17.
 */
public interface GreetingRepository {
    GreetingDTO getGreeting(Long id, String content);
}
