package com.astronova.project.controller;

import com.astronova.project.dto.ProjectRequest;
import com.astronova.project.dto.ProjectResponse;
import com.astronova.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

// PUBLIC APIs

    @GetMapping("/api/projects")
    public List<ProjectResponse> getProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping("/api/projects/{id}")
    public ProjectResponse getProject(
            @PathVariable Long id) {

        return projectService.getProjectById(id);
    }

// ADMIN APIs

    @PostMapping("/api/admin/projects")
    public ProjectResponse createProject(
            @Valid
            @RequestBody ProjectRequest request) {

        return projectService.createProject(request);
    }

    @PutMapping("/api/admin/projects/{id}")
    public ProjectResponse updateProject(
            @Valid
            @PathVariable Long id,
            @RequestBody ProjectRequest request) {

        return projectService.updateProject(id, request);
    }

    @DeleteMapping("/api/admin/projects/{id}")
    public void deleteProject(
            @PathVariable Long id) {

        projectService.deleteProject(id);
    }

    @GetMapping("/api/admin/projects")
    public List<ProjectResponse> getAllProjectsAdmin() {

        return projectService.getAllProjects();
    }

}
