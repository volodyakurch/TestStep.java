package com.tms.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

    // Getters and Setters
}