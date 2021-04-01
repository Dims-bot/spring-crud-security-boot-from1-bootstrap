package com.javamentor.springcrudsecuritybootfrom1.transferObject;

import lombok.Data;

import java.util.Set;

@Data
public class SingleRequest {
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private Set<String> roles;
    private String password;


}
