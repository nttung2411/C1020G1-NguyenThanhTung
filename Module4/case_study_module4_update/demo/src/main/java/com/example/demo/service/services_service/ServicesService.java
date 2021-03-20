package com.example.demo.service.services_service;

import com.example.demo.models.services.RentTypeService;
import com.example.demo.models.services.Service;
import com.example.demo.models.services.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicesService {
    void saveService(Service service);
    Service findById(String id);
    Page<Service> findAll(Pageable pageable);
    void deleteById(String id);
    TypeService findTypeServiceId(Integer id);
    List<RentTypeService> findAllRentType();
}
