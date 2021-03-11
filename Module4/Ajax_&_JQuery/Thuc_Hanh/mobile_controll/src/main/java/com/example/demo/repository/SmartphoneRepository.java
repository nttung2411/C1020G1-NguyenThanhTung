package com.example.demo.repository;

import com.example.demo.models.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
