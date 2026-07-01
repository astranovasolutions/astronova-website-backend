package com.astronova.upload.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileUploadResponse {

    private String fileName;

    private String url;
}
