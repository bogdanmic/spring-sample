package com.gd.spring.netflix.feign.rest.clients;

import com.gd.spring.netflix.feign.dtos.InstanceDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchServicesResourceImpl implements SearchServicesResource {
    /**
     * If we implement the interface of a FeignClient then the implementation methods will be used as fallback by Hystrix
     *
     * @param applicationName
     * @return
     */
    @Override
    public List<InstanceDTO> serviceInstancesByApplicationName(String applicationName) {
        List<InstanceDTO> instances = new ArrayList<>();
        instances.add(new InstanceDTO("fallback-uri-" + applicationName, "fallback-host-" + applicationName, "fallback-serviceId-" + applicationName));
        return instances;
    }
}
