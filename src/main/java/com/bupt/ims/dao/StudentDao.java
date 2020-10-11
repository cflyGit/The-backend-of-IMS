package com.bupt.ims.dao;

import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;

import java.util.List;

public interface StudentDao {

    int insert(Student student);

    int update(Student student);

    Student findById(long id);

    Student findByName(String name);

    List<Student> findByAcademy(String academy);

    List<Student> findByTutor(Tutor tutor);

    List<Student> findByAge(int age);

    Student findByPhone(String phone);

    Student findByQQ(String qq);

    Student findByWechat(String wechat);

    Student findByEmail(String email);

}
