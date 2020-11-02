package com.bupt.ims.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {
    private String role_id;
    private long permission_id;

    public RolePermission(String role_id, long permission_id) {
        this.role_id = role_id;
        this.permission_id = permission_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(long permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "role_id='" + role_id + '\'' +
                ", permission_id='" + permission_id + '\'' +
                '}';
    }
}
