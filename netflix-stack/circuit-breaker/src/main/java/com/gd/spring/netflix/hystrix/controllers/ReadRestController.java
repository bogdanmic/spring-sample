package com.gd.spring.netflix.hystrix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class ReadRestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/search-service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        // Fetch the eureka-client service instance. It has the name:
        List<ServiceInstance> instances = this.discoveryClient.getInstances("a-bootiful-client");
        //Then we fetch the first instance from the list..
        if (!instances.isEmpty()) {
            ServiceInstance instance = instances.get(0);
            // Using the service instance that we got search for other instances with a given name.
            // We can do the same in this app but we want to search using another app.
            RestTemplate restTemplate = new RestTemplate();
            URI uri = URI.create(instance.getUri() + "/service-instances/" + applicationName);

            return restTemplate.getForObject(uri, List.class);
        }
        return Collections.emptyList();
    }
}
