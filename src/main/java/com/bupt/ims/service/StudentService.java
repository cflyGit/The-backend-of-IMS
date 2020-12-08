package com.bupt.ims.service;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.dto.MyInternship;
import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    boolean insert(Student student);

    boolean deleteOne(String id);

    int update(Student student);

    Student findById(String id);

    List<Student> findByName(String name);

    List<Student> findByAcademy(String academy);

    List<Student> findByTutor(Tutor tutor);

    List<Student> findByAge(int age);

    Student findByPhone(String phone);

    Student findByQQ(String qq);

    Student findByWechat(String wechat);

    Student findByEmail(String email);

    boolean applyItem(long id, String file);

    List<MyInternship> getInternships();

    JsonResult uploadCV(MultipartFile file);

    JsonResult getInternshipAudit();

    JsonResult auditAgree(long order_id, String actor);
}
