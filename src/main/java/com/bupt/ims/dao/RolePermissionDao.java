package com.bupt.ims.dao;

import com.bupt.ims.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    List<RolePermission> findByRolePermission(String role);
}
