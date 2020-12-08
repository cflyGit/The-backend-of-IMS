package com.bupt.ims.serviceImpl;

import com.bupt.ims.dto.HomeHead;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.entity.Project;
import com.bupt.ims.service.HomeService;
import com.bupt.ims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomServiceImpl implements HomeService {
    @Autowired
    private ProjectService projectService;

    @Override
    public HomeHead getHead() {
        List<Project> projects = new ArrayList<>();
        projects = projectService.findByStatus(3, 4);
        HomeHead hh = new HomeHead();
        List<String> info = new ArrayList<>();
        List<String> images = new ArrayList<>();
        List<IntershipProject> isps = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++) {
            info.add(projects.get(i).getName());
            images.add("../../assets/img/projects/0" + i +".jpg");
            IntershipProject isp = new IntershipProject(projects.get(i));
            isps.add(isp);
        }
        hh.setInfo(info);
        hh.setImages(images);
        hh.setProjects(isps);
        return hh;
    }
}
