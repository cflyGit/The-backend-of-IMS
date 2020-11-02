package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.StudentDao;
import com.bupt.ims.dao.UserDao;
import com.bupt.ims.dao.UserRoleDao;
import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.entity.UserRole;
import com.bupt.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public boolean insert(Student student) {
        IMSUser user = new IMSUser(student.getStudent_id(), BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
//        User user = new User(student.getStudent_id(), student.getPassword());
        UserRole userRole = new UserRole(user.getUsername(), "Student");
        int s = 0, u = 0, ur = 0;
        try {
            s = studentDao.insert(student);
            u = userDao.insert(user);
            ur = userRoleDao.insert(userRole);
        }catch (Exception e) {
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public boolean deleteOne(String id) {
        int s = 0, u = 0, ur = 0;
        try {
            s = studentDao.deleteOne(id);
            u = userDao.deleteById(id);
            ur = userRoleDao.deleteById(id);
        }catch(Exception e) {
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
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
