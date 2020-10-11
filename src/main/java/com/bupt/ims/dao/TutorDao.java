package com.bupt.ims.dao;

import com.bupt.ims.entity.Tutor;

import java.util.List;

public interface TutorDao  {

    int insert(Tutor tutor);

    int update(Tutor tutor);

    List<Tutor> findByAcademy(String Academy);

    Tutor findById(Long id);

    List<Tutor> findByName(String name);

    Tutor findByPhone(String phone);

    Tutor findByQQ(String qq);

    Tutor findByWechat(String wechat);

    Tutor findByEmail(String email);

    List<Tutor> findByAge(int age);

    int deleteOne(Long id);
}
