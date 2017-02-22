package com.gd.spring.netflix.hystrix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceInstancesService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> searchServiceInstancesByApplicationName(String applicationName) {
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
