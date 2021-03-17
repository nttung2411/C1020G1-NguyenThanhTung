package com.example.demo.repository.service_repository;

import com.example.demo.models.services.RentTypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentTypeService,Integer> {
}
