package com.bupt.ims.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.dao.ItemListDao;
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
    public List<ItemList> findByProjectId(long id) {
        return itemListDao.findByProjectId(id);
    }

    @Override
    public List<ItemList> findByInternsId(long id) {
        return itemListDao.findByInternsId(id);
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
    public JSONObject getItemList(int status) {
        List<JSONObject> jsons = new ArrayList<>();
        List<Project> projects = projectService.findByStatus(status);
        for (Project p : projects) {
            JSONObject json = new JSONObject();
            long project_id = p.getProject_id();
            List<ItemList> itemList = itemListDao.findByProjectId(project_id);
            StringBuffer interns = null;
            for (ItemList item : itemList) {
            }
            json.put("project_id", project_id);
        }
        return null;
    }
}
