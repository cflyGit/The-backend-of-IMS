package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.BaseDao;
import com.bupt.ims.entity.Base;
import com.bupt.ims.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseDao baseDao;

    @Override
    public int insert(Base base) {
        return baseDao.insert(base);
    }

    @Override
    public int deleteOne(long id) {
        return baseDao.deleteOne(id);
    }

    @Override
    public int update(Base base) {
        return baseDao.update(base);
    }

    @Override
    public List<Base> findByName(String name) {
        return baseDao.findByName(name);
    }
}
