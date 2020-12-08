package com.bupt.ims.service;

import com.bupt.ims.entity.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    int insert(Project project);

    int update(Project project);

    Project findById(long id);

    List<Project> findByName(String name);

    List<Project> findByBase(String base_id);

    List<Project> findByStatus(int status);

    List<Project> findByStatus(int status, int size);

    List<Project> findByDate(Date start, Date end, String status);
}
