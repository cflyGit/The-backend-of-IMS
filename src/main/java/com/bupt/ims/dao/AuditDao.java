package com.bupt.ims.dao;

import com.bupt.ims.entity.Audit;

public interface AuditDao {
    int insert(Audit audit);

    int update(Audit audit);

    Audit findById(long id);
}
