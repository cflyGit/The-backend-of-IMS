package com.bupt.ims;

import com.bupt.ims.common.util.FileManagement;
import com.bupt.ims.common.util.ParseExcelFile;
import com.bupt.ims.dao.AdminDao;
import com.bupt.ims.dao.TutorDao;
import com.bupt.ims.entity.Admin;
import com.bupt.ims.entity.ItemList;
import com.bupt.ims.entity.Project;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.AdminService;
import com.bupt.ims.service.ItemListService;
import com.bupt.ims.service.ProjectService;
import com.bupt.ims.service.TutorService;
import com.bupt.ims.serviceImpl.AdminServiceImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ImsApplicationTests {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private TutorDao tutorDao;

    @Autowired
    private ItemListService itemListService;

    @Autowired
    private AdminService adminServiceImpl;

    @Autowired
    private TutorService tutorServiceImpl;

    @Autowired
    private ProjectService projectService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindByStatusIn4() {
        List<Project> projectList = new ArrayList<>();
        projectList = projectService.findByStatus(3, 2);
        System.out.println(projectList);
    }

    @Test
    void testProjectFindByName() {
        List<Project> projectList = new ArrayList<>();
        projectList = projectService.findByName("研究生实习实践管理平台2");
        System.out.println(projectList);
    }

    @Test
    void mybatisTest() {
        Admin admin = adminDao.queryById("1000");
        System.out.println(admin);
    }

    @Test
    void loginTest() {
        Admin admin = new Admin();
        admin.setAdmin_id("1000");
        admin.setName("admin");
        admin.setPassword("12345");

//        System.out.println("res: [[[[[ " + adminServiceImpl.login(admin));
    }

    @Test
    void ItemListUpdateTest() {
        ItemList itemList = new ItemList();
        itemList.setProject_id(100000);
        itemList.setStudent_id(100000);
        itemList.setFile("fff.pdf");

        if (itemListService.insert(itemList) > 0 )
            System.out.println("insert successful");

        System.out.println("itemList" + itemList);
        itemList.setStatus(1);
        if (itemListService.update(itemList) > 0) {
            System.out.println("update successfule");
        }

    }

    @Test
    void tutorTest() {
        Tutor tutor = new Tutor();
        tutor.setTutor_id("1000");
        tutor.setName("Mr.Lin");
        tutor.setAge(23);
        tutor.setPassword("12345");

        System.out.println("res: [[[[[" + tutorServiceImpl.insert(tutor));
    }

    @Test
    void reflectTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String s = "com.bupt.ims.entity.Tutor";
        Class<?> clazz = Class.forName(s);
        Object t = clazz.newInstance();
        System.out.println(t.toString());
    }
}
