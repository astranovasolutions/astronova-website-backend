package com.astronova.servicecatalog.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ServiceResponse {

    private Long id;

    private String title;

    private String description;

    private String icon;

    private Boolean active;

    private LocalDateTime createdAt;

}
