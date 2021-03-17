package com.example.demo.repository.employee_repository;

import com.example.demo.models.employee.FuramaRoleUser;
import com.example.demo.models.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuramaRoleUserRepository extends JpaRepository<FuramaRoleUser,Integer> {
    List<FuramaRoleUser> findByFuramaUser(FuramaUser furamaUser);
}
