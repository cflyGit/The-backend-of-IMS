package com.bupt.ims.service;

import com.bupt.ims.entity.Audit;

public interface AuditService {
    int insert(Audit audit);

    int update(Audit audit);

    Audit findById(long id);

    int statusBack(Audit audit);
}
