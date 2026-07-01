package com.astronova.dashboard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private long totalLeads;

    private long newLeads;

    private long totalProjects;

    private long totalServices;

    private long totalTeamMembers;

    private long totalTestimonials;

    private long totalBlogs;
}
