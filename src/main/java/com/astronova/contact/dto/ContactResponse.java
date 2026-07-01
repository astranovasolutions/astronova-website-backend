package com.astronova.contact.dto;

import com.astronova.contact.enums.LeadStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ContactResponse {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String projectType;

    private String budget;

    private String message;

    private LeadStatus status;

    private LocalDateTime createdAt;

}
