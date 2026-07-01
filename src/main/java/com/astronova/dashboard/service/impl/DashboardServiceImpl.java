package com.astronova.dashboard.service.impl;

import com.astronova.blog.repository.BlogRepository;
import com.astronova.contact.enums.LeadStatus;
import com.astronova.contact.repository.ContactRepository;
import com.astronova.dashboard.dto.DashboardResponse;
import com.astronova.dashboard.service.DashboardService;
import com.astronova.servicecatalog.repository.ServiceCatalogRepository;
import com.astronova.team.repository.TeamMemberRepository;
import com.astronova.testimonial.repository.TestimonialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl
        implements DashboardService {

    private final ContactRepository contactRepository;
    private final ServiceCatalogRepository serviceCatalogRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final TestimonialRepository testimonialRepository;
    private final BlogRepository blogRepository;

    @Override
    public DashboardResponse getDashboardStats() {

        return DashboardResponse.builder()
                .totalLeads(
                        contactRepository.count()
                )
                .newLeads(
                        contactRepository.countByStatus(
                                LeadStatus.NEW
                        )
                )
                .totalProjects(0)
                .totalServices(
                        serviceCatalogRepository.count()
                )
                .totalTeamMembers(
                        teamMemberRepository.count()
                )
                .totalTestimonials(
                        testimonialRepository.count()
                )
                .totalBlogs(
                        blogRepository.count()
                )


                .build();
    }

}