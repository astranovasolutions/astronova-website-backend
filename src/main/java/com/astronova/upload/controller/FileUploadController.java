package com.astronova.upload.controller;

import com.astronova.upload.dto.FileUploadResponse;
import com.astronova.upload.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public FileUploadResponse uploadFile(
            @RequestParam("file")
            MultipartFile file) {

        return fileUploadService
                .uploadFile(file);
    }
}