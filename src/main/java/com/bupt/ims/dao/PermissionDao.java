package com.bupt.ims.dao;

import com.bupt.ims.entity.Permission;

import java.util.List;

public interface PermissionDao {
    Permission findByPermission(long permission_id);
}
