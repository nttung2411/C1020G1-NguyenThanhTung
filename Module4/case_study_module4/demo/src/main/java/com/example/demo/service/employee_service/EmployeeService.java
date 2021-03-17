package com.example.demo.service.employee_service;

import com.example.demo.models.employee.Division;
import com.example.demo.models.employee.Education;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Page<Employee> findAllEmployee(Pageable pageable);
    void deleteEmployee(String id);
    Employee findById(String id);
    List<Division> findAllDivision();
    List<Position> findAllPosition();
    List<Education> findAllEducation();
    List<Employee> findEmployeeByName(String name);
}
