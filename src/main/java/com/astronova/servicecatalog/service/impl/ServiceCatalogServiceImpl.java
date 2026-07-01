package com.astronova.servicecatalog.service.impl;

import com.astronova.exception.ResourceNotFoundException;
import com.astronova.servicecatalog.dto.ServiceRequest;
import com.astronova.servicecatalog.dto.ServiceResponse;
import com.astronova.servicecatalog.entity.ServiceCatalog;
import com.astronova.servicecatalog.repository.ServiceCatalogRepository;
import com.astronova.servicecatalog.service.ServiceCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCatalogServiceImpl
        implements ServiceCatalogService {

    private final ServiceCatalogRepository serviceRepository;

    @Override
    public ServiceResponse createService(
            ServiceRequest request) {

        ServiceCatalog service =
                ServiceCatalog.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .icon(request.getIcon())
                        .active(request.getActive())
                        .build();

        return mapToResponse(
                serviceRepository.save(service));
    }

    @Override
    public ServiceResponse updateService(
            Long id,
            ServiceRequest request) {

        ServiceCatalog service =
                serviceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Service not found"));

        service.setTitle(request.getTitle());
        service.setDescription(request.getDescription());
        service.setIcon(request.getIcon());
        service.setActive(request.getActive());

        return mapToResponse(
                serviceRepository.save(service));
    }

    @Override
    public ServiceResponse getServiceById(Long id) {

        return mapToResponse(
                serviceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Service not found")));
    }

    @Override
    public List<ServiceResponse> getAllServices() {

        return serviceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteService(Long id) {

        ServiceCatalog service =
                serviceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Service not found"));

        serviceRepository.delete(service);
    }

    private ServiceResponse mapToResponse(
            ServiceCatalog service) {

        return ServiceResponse.builder()
                .id(service.getId())
                .title(service.getTitle())
                .description(service.getDescription())
                .icon(service.getIcon())
                .active(service.getActive())
                .createdAt(service.getCreatedAt())
                .build();
    }

}
