package com.astronova.blog.service.impl;

import com.astronova.blog.dto.BlogRequest;
import com.astronova.blog.dto.BlogResponse;
import com.astronova.blog.entity.Blog;
import com.astronova.blog.repository.BlogRepository;
import com.astronova.blog.service.BlogService;
import com.astronova.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public BlogResponse createBlog(BlogRequest request) {

        Blog blog = Blog.builder()
                .title(request.getTitle())
                .slug(generateSlug(request.getTitle()))
                .author(request.getAuthor())
                .summary(request.getSummary())
                .content(request.getContent())
                .imageUrl(request.getImageUrl())
                .published(request.getPublished())
                .build();

        return mapToResponse(
                blogRepository.save(blog));
    }

    @Override
    public BlogResponse updateBlog(
            Long id,
            BlogRequest request) {

        Blog blog = blogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Blog not found"));

        blog.setTitle(request.getTitle());
        blog.setSlug(generateSlug(request.getTitle()));
        blog.setAuthor(request.getAuthor());
        blog.setSummary(request.getSummary());
        blog.setContent(request.getContent());
        blog.setImageUrl(request.getImageUrl());
        blog.setPublished(request.getPublished());

        return mapToResponse(
                blogRepository.save(blog));
    }

    @Override
    public BlogResponse getBlogById(Long id) {

        return mapToResponse(
                blogRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Blog not found")));
    }

    @Override
    public BlogResponse getBlogBySlug(String slug) {

        return mapToResponse(
                blogRepository.findBySlug(slug)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Blog not found")));
    }

    @Override
    public List<BlogResponse> getAllBlogs() {

        return blogRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteBlog(Long id) {

        blogRepository.deleteById(id);
    }

    private String generateSlug(String title) {

        return title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-");
    }

    private BlogResponse mapToResponse(Blog blog) {

        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .slug(blog.getSlug())
                .author(blog.getAuthor())
                .summary(blog.getSummary())
                .content(blog.getContent())
                .imageUrl(blog.getImageUrl())
                .published(blog.getPublished())
                .createdAt(blog.getCreatedAt())
                .build();
    }

}
