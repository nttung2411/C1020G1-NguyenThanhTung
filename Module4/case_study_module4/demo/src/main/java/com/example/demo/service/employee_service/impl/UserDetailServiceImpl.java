package com.example.demo.service.employee_service.impl;

import com.example.demo.models.employee.FuramaRoleUser;
import com.example.demo.models.employee.FuramaUser;
import com.example.demo.repository.employee_repository.FuramaRoleUserRepository;
import com.example.demo.repository.employee_repository.FuramaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    FuramaUserRepository furamaUserRepository;

    @Autowired
    FuramaRoleUserRepository furamaRoleUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FuramaUser furamaUser = furamaUserRepository.findById(username).orElse(null);
        if(furamaUser == null){
            throw new UsernameNotFoundException(username + "not found");
        }

        List<FuramaRoleUser> furamaRoleUsers = furamaRoleUserRepository.findByFuramaUser(furamaUser);

        List<GrantedAuthority> grandList = new ArrayList<>();
        if(furamaRoleUsers != null){
            for (FuramaRoleUser roleUser : furamaRoleUsers){
                GrantedAuthority authority = new SimpleGrantedAuthority(roleUser.getFuramaRole().getRoleName());
                grandList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(furamaUser.getUserName(),furamaUser.getPassword(),grandList);

        return userDetails;
    }
}
