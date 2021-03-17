package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuramaUserRepository extends JpaRepository<FuramaUser,String> {
}
