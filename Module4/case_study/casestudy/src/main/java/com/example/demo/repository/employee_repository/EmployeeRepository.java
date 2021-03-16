package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    List<Employee> findAllByEmployeeNameContaining(String name);
}
