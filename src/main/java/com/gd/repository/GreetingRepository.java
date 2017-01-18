package com.gd.repository;

import com.gd.dto.GreetingDTO;

/**
 * Created by mic on 1/18/17.
 */
public interface GreetingRepository {
    GreetingDTO getGreeting(Long id, String content);
}
