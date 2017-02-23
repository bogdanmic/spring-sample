package com.gd.spring.netflix.eureka.dtos;

public class InstanceDTO {
    private String uri;
    private String host;
    private String serviceId;

    public InstanceDTO(String uri, String host, String serviceId) {
        this.uri = uri;
        this.host = host;
        this.serviceId = serviceId;
    }


    public String getUri() {
        return uri;
    }

    public String getHost() {
        return host;
    }

    public String getServiceId() {
        return serviceId;
    }
}
