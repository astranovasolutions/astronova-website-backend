package com.astronova.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrorResponse {

    private boolean success;

    private String message;

    private LocalDateTime timestamp;
}