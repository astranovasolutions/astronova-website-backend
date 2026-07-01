package com.astronova.blog.controller;

import com.astronova.blog.dto.BlogRequest;
import com.astronova.blog.dto.BlogResponse;
import com.astronova.blog.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

// PUBLIC APIs

    @GetMapping("/api/blogs")
    public List<BlogResponse> getBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/api/blogs/{id}")
    public BlogResponse getBlog(
            @PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/api/blogs/slug/{slug}")
    public BlogResponse getBlogBySlug(
            @PathVariable String slug) {
        return blogService.getBlogBySlug(slug);
    }

// ADMIN APIs

    @PostMapping("/api/admin/blogs")
    public BlogResponse createBlog(
            @Valid
            @RequestBody BlogRequest request) {
        return blogService.createBlog(request);
    }


    @PutMapping("/api/admin/blogs/{id}")
    public BlogResponse updateBlog(
            @Valid
            @PathVariable Long id,
            @RequestBody BlogRequest request) {
        return blogService.updateBlog(id, request);
    }

    @DeleteMapping("/api/admin/blogs/{id}")
    public void deleteBlog(
            @PathVariable Long id) {
        blogService.deleteBlog(id);
    }

    @GetMapping("/api/admin/blogs")
    public List<BlogResponse> getAllBlogsAdmin() {
        return blogService.getAllBlogs();
    }



}
