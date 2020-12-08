package com.bupt.ims.dao;

import com.bupt.ims.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProjectDao {

    int insert(Project project);

    int update(Project project);

    Project findById(long id);

    List<Project> findByName(String name);

    List<Project> findByStatus(int status);

    List<Project> findByBaseId(String base_id);

    List<Project> findByStatusIn4(int status, int size);

    List<Project> findByTime(@Param("start") Date start, @Param("end") Date end, @Param("status") String status);
}
