package com.astronova.testimonial.controller;

import com.astronova.testimonial.dto.TestimonialRequest;
import com.astronova.testimonial.dto.TestimonialResponse;
import com.astronova.testimonial.service.TestimonialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService testimonialService;

// PUBLIC APIs

    @GetMapping("/api/testimonials")
    public List<TestimonialResponse> getTestimonials() {
        return testimonialService.getAllTestimonials();
    }

    @GetMapping("/api/testimonials/{id}")
    public TestimonialResponse getTestimonial(
            @PathVariable Long id) {
        return testimonialService.getTestimonialById(id);
    }

// ADMIN APIs

    @PostMapping("/api/admin/testimonials")
    public TestimonialResponse createTestimonial(
            @Valid
            @RequestBody TestimonialRequest request) {
        return testimonialService.createTestimonial(request);
    }

    @PutMapping("/api/admin/testimonials/{id}")
    public TestimonialResponse updateTestimonial(
            @Valid
            @PathVariable Long id,
            @RequestBody TestimonialRequest request) {
        return testimonialService.updateTestimonial(id, request);
    }

    @DeleteMapping("/api/admin/testimonials/{id}")
    public void deleteTestimonial(
            @PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
    }

    @GetMapping("/api/admin/testimonials")
    public List<TestimonialResponse> getAllTestimonialsAdmin() {
        return testimonialService.getAllTestimonials();
    }

}
