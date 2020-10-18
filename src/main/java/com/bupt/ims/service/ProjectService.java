package com.bupt.ims.service;

import com.bupt.ims.entity.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {

    int insert(Project project);

    int update(Project project);

    Project findById(long id);

    List<Project> findByName(String name);

    List<Project> findByStatus(int status);

    List<Project> findByDate(Date start, Date end, String status);
}
