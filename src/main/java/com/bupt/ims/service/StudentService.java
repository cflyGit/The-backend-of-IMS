package com.bupt.ims.service;

import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;

import java.util.List;

public interface StudentService {
    int insert(Student student);

    int deleteOne(long id);

    int update(Student student);

    Student findById(long id);

    List<Student> findByName(String name);

    List<Student> findByAcademy(String academy);

    List<Student> findByTutor(Tutor tutor);

    List<Student> findByAge(int age);

    Student findByPhone(String phone);

    Student findByQQ(String qq);

    Student findByWechat(String wechat);

    Student findByEmail(String email);
}
