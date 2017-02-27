package com.gd.spring.oauth2.dto;

import java.util.UUID;

public class MessageDTO {

    private String id = UUID.randomUUID().toString();
    private String content;

    public MessageDTO(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
