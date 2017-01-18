package com.gd.services;

import com.gd.dto.GreetingDTO;

/**
 * Created by mic on 1/18/17.
 */
public interface GreetingService {
    GreetingDTO getGreeting(String name);
}
