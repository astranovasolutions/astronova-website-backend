package com.astronova.testimonial.service;

import com.astronova.testimonial.dto.TestimonialRequest;
import com.astronova.testimonial.dto.TestimonialResponse;

import java.util.List;

public interface TestimonialService {

    TestimonialResponse createTestimonial(
            TestimonialRequest request);

    TestimonialResponse updateTestimonial(
            Long id,
            TestimonialRequest request);

    TestimonialResponse getTestimonialById(
            Long id);

    List<TestimonialResponse> getAllTestimonials();

    void deleteTestimonial(Long id);

}
