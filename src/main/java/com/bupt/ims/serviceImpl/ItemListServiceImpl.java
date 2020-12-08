package com.bupt.ims.serviceImpl;

import com.bupt.ims.dao.ItemListDao;
import com.bupt.ims.dto.InternshipAudit;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.entity._InternshipAudit;
import com.bupt.ims.entity.ItemList;
import com.bupt.ims.entity.Project;
import com.bupt.ims.service.ItemListService;
import com.bupt.ims.service.ProjectService;
import com.bupt.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemListServiceImpl implements ItemListService {
    @Autowired
    private ItemListDao itemListDao;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private StudentService studentService;

    @Override
    public int insert(ItemList itemList) {
        return itemListDao.insert(itemList);
    }

    @Override
    public int update(ItemList itemList) {
        return itemListDao.update(itemList);
    }

    @Override
    public int findBy2Id(long project_id, long student_id) {
        return itemListDao.findBy2Id(project_id, student_id);
    }

    @Override
    public ItemList findByOrderId(long order_id) {
        return itemListDao.findByOrderId(order_id);
    }

    @Override
    public List<ItemList> findByProjectId(long id) {
        return itemListDao.findByProjectId(id);
    }

    @Override
    public List<ItemList> findByInternsId(long id) {
        return itemListDao.findByInternsId(id);
    }

    @Override
    public List<IntershipProject> findByInternsName(String name) {
        List<Project> projects = projectService.findByName(name);
        List<IntershipProject> intershipProjectList = new ArrayList<>();
        for (Project p : projects) {
            if (p.getStatus() > 2) {
                intershipProjectList.add(new IntershipProject(p));
            }
        }

        return intershipProjectList;
    }

    @Override
    public int deleteByProjectId(long id) {
        return itemListDao.deleteByProjectId(id);
    }

    @Override
    public int deleteByInternsId(long id){
        return itemListDao.deleteByInternsId(id);
    }

    @Override
    public List<IntershipProject> getItemList(int status) {
        List<Project> projects = projectService.findByStatus(status);
        List<IntershipProject> intershipProjectList = new ArrayList<>();
        for (Project p : projects) {
            intershipProjectList.add(new IntershipProject(p));
        }
        return intershipProjectList;
    }

    @Override
    public List<InternshipAudit> getItemListAudit(int status) {
        List<Project> projects = projectService.findByStatus(status);
        return getILA(projects);
    }

    @Override
    public List<InternshipAudit> getItemListAudit(String base_id) {
        List<Project> projects = projectService.findByBase(base_id);
        return getILA(projects);
    }

    private List<InternshipAudit> getILA(List<Project> projects) {
        List<InternshipAudit> internshipAuditList = new ArrayList<>();
        System.out.println("projects:" + projects);
        for (Project p : projects) {
            List<ItemList> itemListList = itemListDao.findByProjectId(p.getProject_id());
            System.out.println("itemList:" + itemListList);
            for (ItemList il : itemListList) {
                String student_name = studentService.findById(String.valueOf(il.getStudent_id())).getName();
                internshipAuditList.add(new InternshipAudit(p, il, student_name));
            }
        }
        return internshipAuditList;
    }

}
