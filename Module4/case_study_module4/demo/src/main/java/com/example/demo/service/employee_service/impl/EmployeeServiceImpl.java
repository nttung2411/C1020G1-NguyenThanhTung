package com.example.demo.service.employee_service.impl;

import com.example.demo.models.employee.*;
import com.example.demo.repository.employee_repository.*;
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

    @Autowired
    FuramaUserRepository furamaUserRepository;

    @Autowired
    FuramaRoleUserRepository furamaRoleUserRepository;

    @Autowired
    FuramaRoleRepository furamaRoleRepository;

    @Override
    public void saveEmployee(Employee employee) {

        FuramaUser furamaUser = new FuramaUser();
        furamaUser.setUserName(employee.getEmployeeId());
        furamaUser.setPassword("123456");
        furamaUserRepository.save(furamaUser);

        if(employee.getPosition().getPositionId() == 5 || employee.getPosition().getPositionId() == 6){
            FuramaRole furamaRole = furamaRoleRepository.findById(2).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaUser(furamaUser);
            furamaRoleUser.setFuramaRole(furamaRole);

            furamaRoleUserRepository.save(furamaRoleUser);
        }else {

            FuramaRole furamaRole = furamaRoleRepository.findById(1).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaUser(furamaUser);
            furamaRoleUser.setFuramaRole(furamaRole);

            furamaRoleUserRepository.save(furamaRoleUser);
        }

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
