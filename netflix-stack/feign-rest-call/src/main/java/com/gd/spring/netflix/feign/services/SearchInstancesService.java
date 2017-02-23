package com.gd.spring.netflix.feign.services;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchInstancesService {
    public List<ServiceInstance> searchServiceInstancesByApplicationName(String applicationName) {
        return Collections.emptyList();
    }
}
