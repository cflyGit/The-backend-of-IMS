package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.ProjectDao;
import com.bupt.ims.entity.Audit;
import com.bupt.ims.entity.Project;
import com.bupt.ims.service.AuditService;
import com.bupt.ims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private AuditService auditService;

    /**
     * 生成一个project项目表的同时，生成一张审核表
     * @param project
     * @return success:1 error: 0
     */
    @Override
    public int insert(Project project) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        project.setBase(authentication.getName());
        if (projectDao.insert(project) > 0) {
            Audit audit = new Audit();
            audit.setProject_id(project.getProject_id());
            auditService.insert(audit);
            return 1;
        }
        return 0;
    }

    @Override
    public int update(Project project) {
        return projectDao.update(project);
    }

    @Override
    public Project findById(long id) {
        return projectDao.findById(id);
    }

    @Override
    public List<Project> findByName(String name) {
        return projectDao.findByName(name);
    }

    @Override
    public List<Project> findByBase(String base_id) {
        return projectDao.findByBaseId(base_id);
    }

    @Override
    public List<Project> findByStatus(int status) {
        return projectDao.findByStatus(status);
    }

    @Override
    public List<Project> findByStatus(int status, int size) {
        return projectDao.findByStatusIn4(status, size);
    }

    @Override
    public List<Project> findByDate(Date start, Date end, String status) {
        return projectDao.findByTime(start, end, status);
    }
}
