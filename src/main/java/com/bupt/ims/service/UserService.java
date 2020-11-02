package com.bupt.ims.service;

import com.bupt.ims.entity.IMSUser;

public interface UserService {
    int insert(IMSUser user);

    IMSUser findById(String id);
}
