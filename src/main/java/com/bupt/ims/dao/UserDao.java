package com.bupt.ims.dao;

import com.bupt.ims.entity.IMSUser;

public interface UserDao {
    int insert(IMSUser user);

    IMSUser findById(String username);

    int deleteById(String id);
}
