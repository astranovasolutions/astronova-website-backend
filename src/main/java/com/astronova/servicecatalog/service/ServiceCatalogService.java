package com.astronova.servicecatalog.service;

import com.astronova.servicecatalog.dto.ServiceRequest;
import com.astronova.servicecatalog.dto.ServiceResponse;

import java.util.List;

public interface ServiceCatalogService {

    ServiceResponse createService(
            ServiceRequest request);

    ServiceResponse updateService(
            Long id,
            ServiceRequest request);

    ServiceResponse getServiceById(
            Long id);

    List<ServiceResponse> getAllServices();

    void deleteService(Long id);

}
