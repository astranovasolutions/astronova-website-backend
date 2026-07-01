package com.astronova.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    private String phone;
    private String projectType;
    private String budget;

    @NotBlank(message = "Message is required")
    private String message;
}
