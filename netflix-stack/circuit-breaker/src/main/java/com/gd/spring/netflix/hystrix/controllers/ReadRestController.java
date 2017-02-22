package com.gd.spring.netflix.hystrix.controllers;

import com.gd.spring.netflix.hystrix.services.SearchServiceInstancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadRestController {
    @Autowired
    private SearchServiceInstancesService searchServiceInstancesService;

    @RequestMapping("/search-service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return searchServiceInstancesService.searchServiceInstancesByApplicationName(applicationName);
    }
}
