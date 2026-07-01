package com.astronova.project.service;

import com.astronova.project.dto.ProjectRequest;
import com.astronova.project.dto.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    ProjectResponse getProjectById(Long id);

    List<ProjectResponse> getAllProjects();

    void deleteProject(Long id);

}
