package com.gd.spring.services;

import com.gd.spring.dto.GreetingDTO;
import com.gd.spring.repositories.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingServiceImpl implements GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingRepository greetingRepository;

    @Override
    public GreetingDTO getGreeting(String name) {
        return greetingRepository.getGreeting(counter.incrementAndGet(), String.format(template, name));
    }
}
