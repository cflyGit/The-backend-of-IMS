package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.StudentDao;
import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student findById(long id) {
        return studentDao.findById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> findByAcademy(String academy) {
        return studentDao.findByAcademy(academy);
    }

    @Override
    public List<Student> findByTutor(Tutor tutor) {
        return studentDao.findByTutor(tutor);
    }

    @Override
    public List<Student> findByAge(int age) {
        return studentDao.findByAge(age);
    }

    @Override
    public Student findByPhone(String phone) {
        return studentDao.findByPhone(phone);
    }

    @Override
    public Student findByQQ(String qq) {
        return studentDao.findByQQ(qq);
    }

    @Override
    public Student findByWechat(String wechat) {
        return studentDao.findByWechat(wechat);
    }

    @Override
    public Student findByEmail(String email) {
        return studentDao.findByEmail(email);
    }
}
