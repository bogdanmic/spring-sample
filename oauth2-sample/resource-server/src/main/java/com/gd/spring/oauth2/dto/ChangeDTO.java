package com.gd.spring.oauth2.dto;

import java.util.Date;

public class ChangeDTO {
    private Date timestamp = new Date();
    private String user;
    private String message;

    ChangeDTO() {
    }

    public ChangeDTO(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
