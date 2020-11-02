package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.TutorDao;
import com.bupt.ims.dao.UserDao;
import com.bupt.ims.dao.UserRoleDao;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.entity.UserRole;
import com.bupt.ims.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {
    @Autowired
    private TutorDao tutorDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public boolean insert(Tutor tutor) {
        IMSUser user = new IMSUser(tutor.getTutor_id(), BCrypt.hashpw(tutor.getPassword(), BCrypt.gensalt()));
//        User user = new User(tutor.getTutor_id(), tutor.getPassword());
        UserRole userRole = new UserRole(tutor.getTutor_id(), "Tutor");
        int s = 0, u = 0, ur = 0;
        try {
            s = tutorDao.insert(tutor);
            u = userDao.insert(user);
            ur = userRoleDao.insert(userRole);
        }catch (Exception e) {
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public int update(Tutor tutor) {
        int res = tutorDao.update(tutor);
        return res;
    }

    @Override
    public List<Tutor> findByAcademy(String academy) {
        List<Tutor> list = tutorDao.findByAcademy(academy);
        return list;
    }

    @Override
    public Tutor findById(String id) {
        Tutor tutor = tutorDao.findById(id);
        return tutor;
    }

    @Override
    public List<Tutor> findByName(String name) {
        List<Tutor> tutor = tutorDao.findByName(name);
        return tutor;
    }

    @Override
    public Tutor findByPhone(String phone) {
        Tutor tutor = tutorDao.findByPhone(phone);
        return tutor;
    }

    @Override
    public Tutor findByQQ(String qq) {
        Tutor tutor = tutorDao.findByQQ(qq);
        return tutor;
    }

    @Override
    public Tutor findByWechat(String wechat) {
        Tutor tutor = tutorDao.findByWechat(wechat);
        return tutor;
    }

    @Override
    public Tutor findByEmail(String email) {
        Tutor tutor = tutorDao.findByEmail(email);
        return tutor;
    }

    @Override
    public List<Tutor> findByAge(int age) {
        List<Tutor> tutor = tutorDao.findByAge(age);
        return tutor;
    }

    @Override
    public boolean deleteOne(String id) {
        int t = 0, u = 0, ur = 0;
        try {
            t = tutorDao.deleteOne(id);
            u = userDao.deleteById(id);
            ur = userRoleDao.deleteById(id);
        }catch (Exception e) {
            return false;
        }
        return t > 0 && u > 0 && ur > 0;
    }
}
