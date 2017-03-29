package com.gd.spring.models.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SimplePojo {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    public SimplePojo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "SimplePojo[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
