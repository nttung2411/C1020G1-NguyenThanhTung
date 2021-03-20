package com.example.demo.service.services_service.Impl;

import com.example.demo.models.services.RentTypeService;
import com.example.demo.models.services.Service;
import com.example.demo.models.services.TypeService;
import com.example.demo.repository.service_repository.RentTypeRepository;
import com.example.demo.repository.service_repository.ServiceRepository;
import com.example.demo.repository.service_repository.TypeServiceRepository;
import com.example.demo.service.services_service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public void saveService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public TypeService findTypeServiceId(Integer id) {
        return typeServiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<RentTypeService> findAllRentType() {
        return rentTypeRepository.findAll();
    }


}
