package com.example.demo.service.employee_service.impl;

import com.example.demo.models.employee.Division;
import com.example.demo.models.employee.Education;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.Position;
import com.example.demo.repository.employee_repository.DivisionRepository;
import com.example.demo.repository.employee_repository.EducationRepository;
import com.example.demo.repository.employee_repository.EmployeeRepository;
import com.example.demo.repository.employee_repository.PositionRepository;
import com.example.demo.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    EducationRepository educationRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<Education> findAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findAllByEmployeeNameContaining(name);
    }
}
