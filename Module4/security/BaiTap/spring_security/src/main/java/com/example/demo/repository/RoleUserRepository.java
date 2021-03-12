package com.example.demo.repository;

import com.example.demo.models.AppUser;
import com.example.demo.models.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserRepository  extends JpaRepository<RoleUser,Integer> {
    List<RoleUser> findByAppUser(AppUser appUser);
}
