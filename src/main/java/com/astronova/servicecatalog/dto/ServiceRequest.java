package com.astronova.servicecatalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceRequest {

    @NotBlank(message = "Service title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String icon;

    private Boolean active;

}
