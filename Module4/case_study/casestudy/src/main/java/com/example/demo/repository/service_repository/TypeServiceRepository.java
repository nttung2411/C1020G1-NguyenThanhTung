package com.example.demo.repository.service_repository;

import com.example.demo.models.services.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService,Integer>{
}
