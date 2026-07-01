package com.astronova.team.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TeamMemberResponse {

    private Long id;

    private String fullName;

    private String designation;

    private String bio;

    private String imageUrl;

    private String linkedinUrl;

    private String githubUrl;

    private Boolean active;

    private LocalDateTime createdAt;

}
