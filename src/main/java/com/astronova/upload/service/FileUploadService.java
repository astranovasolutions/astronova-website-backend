package com.astronova.upload.service;

import com.astronova.upload.dto.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    FileUploadResponse uploadFile(
            MultipartFile file);
}