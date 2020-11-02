package com.bupt.ims.service;

import java.util.List;

public interface RolePermissionService {
    List<String> findByRole(String role);
}
