package com.bupt.ims.service;

import com.bupt.ims.entity.Base;

import java.util.List;

public interface BaseService {
    int insert(Base base);

    int deleteOne(long id);

    int update(Base base);

    List<Base> findByName(String name);
}
