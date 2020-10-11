package com.bupt.ims.dao;

import com.bupt.ims.entity.Admin;

public interface AdminDao {
    Admin queryById(Long admin_id);
}
