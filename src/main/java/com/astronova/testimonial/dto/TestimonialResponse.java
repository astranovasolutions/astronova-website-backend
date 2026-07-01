package com.astronova.testimonial.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TestimonialResponse {

    private Long id;

    private String clientName;

    private String companyName;

    private String review;

    private Integer rating;

    private String imageUrl;

    private Boolean featured;

    private Boolean active;

    private LocalDateTime createdAt;

}
