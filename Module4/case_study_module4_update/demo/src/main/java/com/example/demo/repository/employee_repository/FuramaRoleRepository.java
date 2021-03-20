package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.FuramaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuramaRoleRepository extends JpaRepository<FuramaRole,Integer> {
}
