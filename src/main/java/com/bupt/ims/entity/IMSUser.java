package com.bupt.ims.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class IMSUser implements UserDetails, Serializable {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> getAuthorities;
    private UserRole userRoles;
    private List<Permission> permissions;

    public IMSUser() {
    }

    public IMSUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public IMSUser(String username, String password, UserRole userRoles) {
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    public IMSUser(String username, String password, Collection<? extends GrantedAuthority> authorities, UserRole userRoles, List<Permission> permissions) {
        this.username = username;
        this.password = password;
        this.getAuthorities = authorities;
        this.userRoles = userRoles;
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.getAuthorities = authorities;
    }

    public UserRole getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRole userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password='" + password + '\'' +
                '}';
    }
}
