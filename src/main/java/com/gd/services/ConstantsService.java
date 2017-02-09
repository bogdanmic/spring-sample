package com.gd.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:config/custom.properties")
public class ConstantsService {

    @Value("${custom.domain.config.a}")
    public Integer CONFIG_A;

    @Value("${custom.domain.config.b}")
    public Integer CONFIG_B;

    @Value("${custom.domain.config.c}")
    public Integer CONFIG_C;
}
