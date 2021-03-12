package com.example.demo.models;

import javax.persistence.*;

@Entity
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoleUser;

    @ManyToOne
    @JoinColumn(name = "id_app_user",referencedColumnName = "userId")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "id_app_role",referencedColumnName = "roleId")
    private AppRole appRole;

    public Integer getIdRoleUser() {
        return idRoleUser;
    }

    public void setIdRoleUser(Integer idRoleUser) {
        this.idRoleUser = idRoleUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
