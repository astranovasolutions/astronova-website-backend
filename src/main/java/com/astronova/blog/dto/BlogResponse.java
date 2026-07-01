package com.astronova.blog.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogResponse {

    private Long id;

    private String title;

    private String slug;

    private String author;

    private String summary;

    private String content;

    private String imageUrl;

    private Boolean published;

    private LocalDateTime createdAt;

}
