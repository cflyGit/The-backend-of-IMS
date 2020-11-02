package com.bupt.ims.service;

import com.bupt.ims.entity.Base;

import java.util.List;

public interface BaseService {
    boolean insert(Base base);

    boolean deleteOne(String id);

    int update(Base base);

    List<Base> findByName(String name);
}
