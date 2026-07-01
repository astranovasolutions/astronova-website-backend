package com.astronova.servicecatalog.repository;

import com.astronova.servicecatalog.entity.ServiceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCatalogRepository
        extends JpaRepository<ServiceCatalog, Long> {
}
