package com.bupt.ims.serviceImpl;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.dao.AuditDao;
import com.bupt.ims.entity.Audit;
import com.bupt.ims.entity.Project;
import com.bupt.ims.service.AuditService;
import com.bupt.ims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.RescaleOp;

@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    private AuditDao auditDao;

    @Autowired
    private ProjectService projectService;

    @Override
    public int insert(Audit audit) {
        return auditDao.insert(audit);
    }

    /**
     * 执行审核更新操作，项目表状态更新
     * @param audit
     * @return success:1 error: 0
     */
    @Override
    public int update(Audit audit) {
        int res = auditDao.update(audit);
        if (res > 0) {
            Project project = projectService.findById(audit.getProject_id());
            project.setStatus(project.getStatus()+1);
            projectService.update(project);
            return 1;
        }
        return 0;
    }

    @Override
    public Audit findById(long id) {
        return auditDao.findById(id);
    }

    @Override
    public int statusBack(Audit audit) {
        long project_id = audit.getProject_id();
        Project project = projectService.findById(project_id);
        project.setStatus(project.getStatus()-1);
        return projectService.update((project));
    }
}
