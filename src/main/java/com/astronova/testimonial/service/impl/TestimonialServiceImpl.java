package com.astronova.testimonial.service.impl;

import com.astronova.exception.ResourceNotFoundException;
import com.astronova.testimonial.dto.TestimonialRequest;
import com.astronova.testimonial.dto.TestimonialResponse;
import com.astronova.testimonial.entity.Testimonial;
import com.astronova.testimonial.repository.TestimonialRepository;
import com.astronova.testimonial.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl
        implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    @Override
    public TestimonialResponse createTestimonial(
            TestimonialRequest request) {

        Testimonial testimonial =
                Testimonial.builder()
                        .clientName(request.getClientName())
                        .companyName(request.getCompanyName())
                        .review(request.getReview())
                        .rating(request.getRating())
                        .imageUrl(request.getImageUrl())
                        .featured(request.getFeatured())
                        .active(request.getActive())
                        .build();

        return mapToResponse(
                testimonialRepository.save(testimonial));
    }

    @Override
    public TestimonialResponse updateTestimonial(
            Long id,
            TestimonialRequest request) {

        Testimonial testimonial =
                testimonialRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Testimonial not found"));

        testimonial.setClientName(request.getClientName());
        testimonial.setCompanyName(request.getCompanyName());
        testimonial.setReview(request.getReview());
        testimonial.setRating(request.getRating());
        testimonial.setImageUrl(request.getImageUrl());
        testimonial.setFeatured(request.getFeatured());
        testimonial.setActive(request.getActive());

        return mapToResponse(
                testimonialRepository.save(testimonial));
    }

    @Override
    public TestimonialResponse getTestimonialById(Long id) {

        return mapToResponse(
                testimonialRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Testimonial not found")));
    }

    @Override
    public List<TestimonialResponse> getAllTestimonials() {

        return testimonialRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteTestimonial(Long id) {

        testimonialRepository.deleteById(id);
    }

    private TestimonialResponse mapToResponse(
            Testimonial testimonial) {

        return TestimonialResponse.builder()
                .id(testimonial.getId())
                .clientName(testimonial.getClientName())
                .companyName(testimonial.getCompanyName())
                .review(testimonial.getReview())
                .rating(testimonial.getRating())
                .imageUrl(testimonial.getImageUrl())
                .featured(testimonial.getFeatured())
                .active(testimonial.getActive())
                .createdAt(testimonial.getCreatedAt())
                .build();
    }

}
