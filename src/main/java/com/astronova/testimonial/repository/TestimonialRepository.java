package com.astronova.testimonial.repository;

import com.astronova.testimonial.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository
        extends JpaRepository<Testimonial, Long> {
}
