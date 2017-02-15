package com.gd.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhoneService phoneService;

    public void perform(Object o) {
        logger.info("--->>> PERFORM: {}. Phones: {}", o, phoneService.countPhones());
    }
}
