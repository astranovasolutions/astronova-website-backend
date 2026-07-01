package com.astronova.project.service.impl;

import com.astronova.exception.ResourceNotFoundException;
import com.astronova.project.dto.ProjectRequest;
import com.astronova.project.dto.ProjectResponse;
import com.astronova.project.entity.Project;
import com.astronova.project.repository.ProjectRepository;
import com.astronova.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        Project project = Project.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .techStack(request.getTechStack())
                .imageUrl(request.getImageUrl())
                .githubUrl(request.getGithubUrl())
                .demoUrl(request.getDemoUrl())
                .featured(request.getFeatured())
                .build();

        return mapToResponse(
                projectRepository.save(project)
        );
    }

    @Override
    public ProjectResponse updateProject(
            Long id,
            ProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setTechStack(request.getTechStack());
        project.setImageUrl(request.getImageUrl());
        project.setGithubUrl(request.getGithubUrl());
        project.setDemoUrl(request.getDemoUrl());
        project.setFeatured(request.getFeatured());

        return mapToResponse(
                projectRepository.save(project)
        );
    }

    @Override
    public ProjectResponse getProjectById(Long id) {

        return mapToResponse(
                projectRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Project not found"))
        );
    }

    @Override
    public List<ProjectResponse> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteProject(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Project not found"));

        projectRepository.delete(project);
    }

    private ProjectResponse mapToResponse(
            Project project) {

        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .techStack(project.getTechStack())
                .imageUrl(project.getImageUrl())
                .githubUrl(project.getGithubUrl())
                .demoUrl(project.getDemoUrl())
                .featured(project.getFeatured())
                .createdAt(project.getCreatedAt())
                .build();
    }

}
