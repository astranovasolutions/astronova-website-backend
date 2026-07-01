package com.astronova.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BlogRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String author;

    private String summary;

    @NotBlank(message = "Content is required")
    private String content;

    private String imageUrl;

    private Boolean published;

}
