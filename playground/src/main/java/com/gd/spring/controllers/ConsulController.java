package com.gd.spring.controllers;

import com.gd.spring.services.ConstantsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsulController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment env;

    @Autowired
    private ConstantsService constantsService;

    @RequestMapping(value = "/consul/service", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getConsulService() {
        // Returns a list with the services named playgroundspringapp
        List<ServiceInstance> list = discoveryClient.getInstances("playgroundspringapp");
        return list;
    }

    @RequestMapping(value = "/consul/config", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getConsulConfig() {
        // The app reads configuration values from consul, if they are not found it uses the default ones in the config files.
        // It looks for the key inside config/playgroundspringapp/ where playgroundspringapp is the spring.application.name configuration
        // You can configure in consul even application variables like server.port
        // See here: http://stackoverflow.com/questions/41756234/consul-key-value-pair-use-for-configuration-in-spring-boot

        // This variable should be refreshed if changed because we configured the watch option.
        String configVariable = env.getProperty("key1", "wtf");

        // Since this variable is loaded when the bean is built it won't get refreshed: constantsService.CONFIG_A
        logger.info("--> Variable read from consul: {} - {}", configVariable, constantsService.CONFIG_A);
        return configVariable;
    }
}
