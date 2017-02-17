package com.gd.spring.services;

import com.gd.spring.dto.GreetingDTO;
import com.gd.spring.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;


@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private GreetingRepository greetingRepository;

    @Autowired
    public void setGreetingRepository(GreetingRepository greetingRepository) {
        // Here we have a setter Spring Bean Injection
        this.greetingRepository = greetingRepository;
    }

    @Override
    public GreetingDTO getGreeting(String name) {
        return greetingRepository.getGreeting(counter.incrementAndGet(), String.format(template, name));
    }
}
