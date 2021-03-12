package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "appUser")
    private Set<RoleUser> roleUserList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(Set<RoleUser> roleUserList) {
        this.roleUserList = roleUserList;
    }
}
