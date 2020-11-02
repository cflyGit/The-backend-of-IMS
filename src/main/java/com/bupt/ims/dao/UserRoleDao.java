package com.bupt.ims.dao;

import com.bupt.ims.entity.UserRole;

public interface UserRoleDao {
    int insert(UserRole userRole);

    UserRole findByUser(String username);

    int deleteById(String id);
}
