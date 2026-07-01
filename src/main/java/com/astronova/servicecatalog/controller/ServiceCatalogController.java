package com.astronova.servicecatalog.controller;

import com.astronova.servicecatalog.dto.ServiceRequest;
import com.astronova.servicecatalog.dto.ServiceResponse;
import com.astronova.servicecatalog.service.ServiceCatalogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceCatalogController {

    private final ServiceCatalogService serviceCatalogService;

// PUBLIC APIs

    @GetMapping("/api/services")
    public List<ServiceResponse> getServices() {

        return serviceCatalogService.getAllServices();
    }

    @GetMapping("/api/services/{id}")
    public ServiceResponse getService(
            @PathVariable Long id) {

        return serviceCatalogService.getServiceById(id);
    }

// ADMIN APIs

    @PostMapping("/api/admin/services")
    public ServiceResponse createService(
            @Valid
            @RequestBody ServiceRequest request) {

        return serviceCatalogService.createService(request);
    }

    @PutMapping("/api/admin/services/{id}")
    public ServiceResponse updateService(
            @Valid
            @PathVariable Long id,
            @RequestBody ServiceRequest request) {

        return serviceCatalogService.updateService(
                id,
                request);
    }

    @DeleteMapping("/api/admin/services/{id}")
    public void deleteService(
            @PathVariable Long id) {

        serviceCatalogService.deleteService(id);
    }

    @GetMapping("/api/admin/services")
    public List<ServiceResponse> getAllServicesAdmin() {

        return serviceCatalogService.getAllServices();
    }

}
