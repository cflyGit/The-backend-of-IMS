package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.BaseDao;
import com.bupt.ims.dao.UserDao;
import com.bupt.ims.dao.UserRoleDao;
import com.bupt.ims.entity.Base;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.entity.UserRole;
import com.bupt.ims.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseDao baseDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public boolean insert(Base base) {
        IMSUser user = new IMSUser(base.getBase_id(), BCrypt.hashpw(base.getPassword(), BCrypt.gensalt()));
//        User user = new User(base.getBase_id(), base.getPassword());
        UserRole userRole = new UserRole(user.getUsername(), "Base");
        int s = 0, u = 0, ur = 0;
        try {
            s = baseDao.insert(base);
            u = userDao.insert(user);
            ur = userRoleDao.insert(userRole);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public boolean deleteOne(String id) {
        int b = 0, u = 0, ur = 0;
        try {
            b = baseDao.deleteOne(id);
            u = userDao.deleteById(id);
            ur = userRoleDao.deleteById(id);
        }catch (Exception e) {
            return false;
        }
        return b > 0 && u > 0 && ur > 0;
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
