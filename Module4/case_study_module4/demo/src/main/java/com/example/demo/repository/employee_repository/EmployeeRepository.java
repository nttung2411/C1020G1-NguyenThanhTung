package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);
    Employee findByFuramaUserUserName(String userName);
    Employee findByEmployeeEmail(String Email);
}
