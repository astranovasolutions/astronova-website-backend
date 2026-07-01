package com.astronova.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequest {

    @NotBlank(message = "Project title is required")
    private String title;

    @NotBlank(message = "Project description is required")
    private String description;

    private String techStack;

    private String imageUrl;

    private String githubUrl;

    private String demoUrl;

    private Boolean featured;

}
