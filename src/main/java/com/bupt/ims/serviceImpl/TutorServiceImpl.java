package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.TutorDao;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    private TutorDao tutorDao;



    @Override
    public int insert(Tutor tutor) {
        int res = tutorDao.insert(tutor);
        return res;
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
    public Tutor findById(Long id) {
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
    public int deleteOne(Long id) {
        return tutorDao.deleteOne(id);
    }
}
