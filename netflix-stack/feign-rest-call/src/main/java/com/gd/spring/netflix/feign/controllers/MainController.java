package com.gd.spring.netflix.feign.controllers;

import com.gd.spring.netflix.feign.services.SearchInstancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private SearchInstancesService searchInstancesService;

    @RequestMapping("/search-service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return searchInstancesService.searchServiceInstancesByApplicationName(applicationName);
    }
}
