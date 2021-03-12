package com.example.demo.service;

import com.example.demo.models.AppUser;
import com.example.demo.models.RoleUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleUserRepository;
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
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    RoleUserRepository roleUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(username);

        if(appUser == null){
            throw new UsernameNotFoundException(username + "not found");
        }

        List<RoleUser> roleUsers = roleUserRepository.findByAppUser(appUser);

        List<GrantedAuthority> grandList = new ArrayList<>();
        if(roleUsers != null){
            for (RoleUser roleUser : roleUsers){
                GrantedAuthority authority = new SimpleGrantedAuthority(roleUser.getAppRole().getRoleName());
                grandList.add(authority);
            }
        }
        return new User(appUser.getUserName(),appUser.getPassword(),grandList);
    }
}
