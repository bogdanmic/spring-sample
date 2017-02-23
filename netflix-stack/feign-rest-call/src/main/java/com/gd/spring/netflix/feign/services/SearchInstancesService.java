package com.gd.spring.netflix.feign.services;

import com.gd.spring.netflix.feign.dtos.InstanceDTO;
import com.gd.spring.netflix.feign.rest.clients.SearchServicesResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchInstancesService {

    @Autowired
    private SearchServicesResource searchServicesResource;

    public List<InstanceDTO> searchServiceInstancesByApplicationName(String applicationName) {
        return searchServicesResource.serviceInstancesByApplicationName(applicationName);
    }
}
