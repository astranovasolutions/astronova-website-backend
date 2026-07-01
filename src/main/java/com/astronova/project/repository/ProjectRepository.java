package com.astronova.project.repository;

import com.astronova.project.entity.Project;
import com.astronova.servicecatalog.repository.ServiceCatalogRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

}
