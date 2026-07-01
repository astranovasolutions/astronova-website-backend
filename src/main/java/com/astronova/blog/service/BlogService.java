package com.astronova.blog.service;

import com.astronova.blog.dto.BlogRequest;
import com.astronova.blog.dto.BlogResponse;

import java.util.List;

public interface BlogService {

    BlogResponse createBlog(BlogRequest request);

    BlogResponse updateBlog(
            Long id,
            BlogRequest request);

    BlogResponse getBlogById(Long id);

    BlogResponse getBlogBySlug(String slug);

    List<BlogResponse> getAllBlogs();

    void deleteBlog(Long id);

}
