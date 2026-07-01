package com.astronova.upload.service.impl;

import com.astronova.exception.BadRequestException;
import com.astronova.upload.dto.FileUploadResponse;
import com.astronova.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileUploadServiceImpl
        implements FileUploadService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public FileUploadResponse uploadFile(
            MultipartFile file) {

        if (file.isEmpty()) {
            throw new BadRequestException(
                    "File is required"
            );
        }

        try {

            Path uploadPath =
                    Paths.get(uploadDir);

            Files.createDirectories(
                    uploadPath
            );

            String originalFileName =
                    file.getOriginalFilename();

            String extension = "";

            if (originalFileName != null &&
                    originalFileName.contains(".")) {

                extension =
                        originalFileName.substring(
                                originalFileName.lastIndexOf(".")
                        );
            }

            String fileName =
                    UUID.randomUUID() + extension;

            Path filePath =
                    uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return FileUploadResponse.builder()
                    .fileName(fileName)
                    .url("/uploads/" + fileName)
                    .build();

        } catch (IOException ex) {

            throw new RuntimeException(
                    "Failed to upload file"
            );
        }
    }
}