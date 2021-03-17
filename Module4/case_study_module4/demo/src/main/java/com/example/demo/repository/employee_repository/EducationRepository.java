package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository  extends JpaRepository<Education,Integer> {
}
