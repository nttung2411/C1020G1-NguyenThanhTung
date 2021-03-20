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
        furamaUser.setPassword("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu");
        furamaUserRepository.save(furamaUser);

        if (employee.getPosition().getPositionId() == 5 || employee.getPosition().getPositionId() == 6) {
            FuramaRole furamaRole = furamaRoleRepository.findById(2).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaUser(furamaUser);
            furamaRoleUser.setFuramaRole(furamaRole);

            furamaRoleUserRepository.save(furamaRoleUser);
        } else {

            FuramaRole furamaRole = furamaRoleRepository.findById(1).orElse(null);

            FuramaRoleUser furamaRoleUser = new FuramaRoleUser();
            furamaRoleUser.setFuramaUser(furamaUser);
            furamaRoleUser.setFuramaRole(furamaRole);

            furamaRoleUserRepository.save(furamaRoleUser);
        }
        employee.setFuramaUser(furamaUser);
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        Employee employee1 = employee;
        System.out.println(employee1);
        FuramaUser furamaUser = employee.getFuramaUser();
        FuramaRoleUser furamaRoleUser = furamaRoleUserRepository.findByFuramaUser(furamaUser);

        if (employee.getPosition().getPositionId() == 5 || employee.getPosition().getPositionId() == 6) {
            FuramaRole furamaRole = furamaRoleRepository.findById(2).orElse(null);
            furamaRoleUser.setFuramaRole(furamaRole);
            furamaRoleUserRepository.save(furamaRoleUser);
        } else {

            FuramaRole furamaRole = furamaRoleRepository.findById(1).orElse(null);
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
    public Page<Employee> findEmployeeByName(Pageable pageable, String name) {
        return employeeRepository.findAllByEmployeeNameContaining(pageable, name);
    }

    @Override
    public Employee findByUserName(String name) {
        return employeeRepository.findByFuramaUserUserName(name);
    }

    @Override
    public String checkDuplicate(Employee employee) {
        if (employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail()) != null) {
            return "Email đã tồn tại";
        } else if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            return "Mã khách hàng đã tồn tại";
        }
        return null;
    }

}
