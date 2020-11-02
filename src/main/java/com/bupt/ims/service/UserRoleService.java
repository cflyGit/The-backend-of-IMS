package com.bupt.ims.service;

import com.bupt.ims.entity.UserRole;

public interface UserRoleService {
    int insert(UserRole userRole);

    UserRole findByUser(String id);
}
