package com.gd.spring.services;


import com.gd.spring.dto.GreetingDTO;

public interface GreetingService {
    GreetingDTO getGreeting(String name);
}
