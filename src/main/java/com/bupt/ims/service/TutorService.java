package com.bupt.ims.service;

import com.bupt.ims.entity.Tutor;

import java.util.List;

public interface TutorService {
    boolean insert(Tutor tutor);

    int update(Tutor tutor);

    List<Tutor> findByAcademy(String academy);

    Tutor findById(String id);

    List<Tutor> findByName(String name);

    Tutor findByPhone(String phone);

    Tutor findByQQ(String qq);

    Tutor findByWechat(String wechat);

    Tutor findByEmail(String email);

    List<Tutor> findByAge(int age);

    boolean deleteOne(String id);

}
