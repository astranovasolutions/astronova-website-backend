package com.astronova.testimonial.dto;

import lombok.Data;

@Data
public class TestimonialRequest {

    private String clientName;

    private String companyName;

    private String review;

    private Integer rating;

    private String imageUrl;

    private Boolean featured;

    private Boolean active;

}
