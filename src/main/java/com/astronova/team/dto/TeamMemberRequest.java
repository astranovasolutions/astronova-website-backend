package com.astronova.team.dto;

import lombok.Data;

@Data
public class TeamMemberRequest {

    private String fullName;

    private String designation;

    private String bio;

    private String imageUrl;

    private String linkedinUrl;

    private String githubUrl;

    private Boolean active;

}
