package com.bupt.ims.dao;

import com.bupt.ims.entity.Base;

import java.util.List;

public interface BaseDao {
    int insert(Base base);

    int update(Base base);

    int deleteOne(long id);

    List<Base> findByName(String name);
}
