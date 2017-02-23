package com.gd.spring.netflix.feign.rest.clients;

import com.gd.spring.netflix.feign.dtos.InstanceDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Here we can add a URL or a name. If we add a name then Feign will look for an service instance with that name
 * on eureka server.
 */
@FeignClient(name = "a-bootiful-client")
public interface SearchServicesResource {

    /**
     * To be able to use path parameters we need to also add the name field, otherwise it fails.
     * @param applicationName
     * @return
     */
    @RequestMapping(value = "/search-service-instances/{applicationName}", method = RequestMethod.GET)
    List<InstanceDTO> serviceInstancesByApplicationName(@PathVariable(name = "applicationName") String applicationName);
}
