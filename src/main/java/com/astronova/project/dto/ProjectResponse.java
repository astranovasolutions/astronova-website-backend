package com.astronova.project.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProjectResponse {

    private Long id;

    private String title;

    private String description;

    private String techStack;

    private String imageUrl;

    private String githubUrl;

    private String demoUrl;

    private Boolean featured;

    private LocalDateTime createdAt;

}
