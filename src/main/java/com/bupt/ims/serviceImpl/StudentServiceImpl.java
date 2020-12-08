package com.bupt.ims.serviceImpl;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.common.util.FileManagement;
import com.bupt.ims.dao.StudentDao;
import com.bupt.ims.dao.UserDao;
import com.bupt.ims.dao.UserRoleDao;
import com.bupt.ims.dto.InternshipAudit;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.dto.MyInternship;
import com.bupt.ims.entity.*;
import com.bupt.ims.service.ItemListService;
import com.bupt.ims.service.ProjectService;
import com.bupt.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private ItemListService itemListService;

    @Autowired
    private ProjectService projectService;

    @Override
    public boolean insert(Student student) {
        IMSUser user = new IMSUser(student.getStudent_id(), BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
//        User user = new User(student.getStudent_id(), student.getPassword());
        UserRole userRole = new UserRole(user.getUsername(), "Student");
        int s = 0, u = 0, ur = 0;
        try {
            s = studentDao.insert(student);
            u = userDao.insert(user);
            ur = userRoleDao.insert(userRole);
        }catch (Exception e) {
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public boolean deleteOne(String id) {
        int s = 0, u = 0, ur = 0;
        try {
            s = studentDao.deleteOne(id);
            u = userDao.deleteById(id);
            ur = userRoleDao.deleteById(id);
        }catch(Exception e) {
            return false;
        }
        return s > 0 && u > 0 && ur > 0;
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public List<Student> findByAcademy(String academy) {
        return studentDao.findByAcademy(academy);
    }

    @Override
    public List<Student> findByTutor(Tutor tutor) {
        return studentDao.findByTutor(tutor);
    }

    @Override
    public List<Student> findByAge(int age) {
        return studentDao.findByAge(age);
    }

    @Override
    public Student findByPhone(String phone) {
        return studentDao.findByPhone(phone);
    }

    @Override
    public Student findByQQ(String qq) {
        return studentDao.findByQQ(qq);
    }

    @Override
    public Student findByWechat(String wechat) {
        return studentDao.findByWechat(wechat);
    }

    @Override
    public Student findByEmail(String email) {
        return studentDao.findByEmail(email);
    }

    @Override
    public boolean applyItem(long id, String file) {
        ItemList il = new ItemList();
        il.setProject_id(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        il.setStudent_id(Long.valueOf(authentication.getName()));
        il.setStatus(0);
        il.setFile(file);
        if (itemListService.findBy2Id(il.getProject_id(), il.getStudent_id()) == 0) { // 同一个同一个项目只能申请一次
            int b = itemListService.insert(il);
            return b > 0;
        }
        return false;
    }

    @Override
    public List<MyInternship> getInternships() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long student_id = Long.valueOf(authentication.getName());
        List<ItemList> li = itemListService.findByInternsId(student_id);
        List<MyInternship> myInternshipList = new ArrayList<>();
        for (ItemList i : li) {
            Project p = projectService.findById(i.getProject_id());
            MyInternship myInternship = new MyInternship(p, i);
            myInternshipList.add(myInternship);
        }
        return myInternshipList;
    }

    @Override
    public JsonResult uploadCV(MultipartFile file) {
        FileManagement fm = new FileManagement();

        String msg = "上传失败，请稍后再试";
        if (file == null) {
            return ResultTool.fail();
        }
        String fileName = UUID.randomUUID().toString() + ".pdf";
        String root = fm.mkdir("uploadCV") + File.separator + fileName;

        if (!(fileName.endsWith(".pdf"))) {
            return ResultTool.fail(ResultCode.FILE_FORMAT_ERROR);
        }
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(root), false))){
            out.write(file.getBytes());
            out.flush();
        }catch (FileNotFoundException e) {
            return ResultTool.fail();
        }catch (IOException e) {
            return ResultTool.fail();
        }
        return ResultTool.success(fileName);
    }

    @Override
    public JsonResult getInternshipAudit() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = userRoleDao.findByUser(authentication.getName()).getRole_id();
        List<InternshipAudit> intershipProjectList;
        switch (role) {
            case "Admin":
                intershipProjectList = itemListService.getItemListAudit(3);
                return ResultTool.success(intershipProjectList);
            case "Base":
                intershipProjectList = itemListService.getItemListAudit(authentication.getName());
                return ResultTool.success(intershipProjectList);
            case "Tutor":
                return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.COMMON_FAIL);
    }

    @Override
    public JsonResult auditAgree(long order_id, String actor) {
        ItemList itemList = itemListService.findByOrderId(order_id);
        System.out.println(itemList);
        switch (actor){
            case "Admin": itemList.setSchool_audit(1); break;
            case "Base": itemList.setBase_audit(1); break;
            case "Tutor1": itemList.setTutor1_audit(1); break;
            case "Tutor2": itemList.setTutor2_audit(1); break;
        }
        // 学院和基地都审核通过
        if (itemList.getSchool_audit() == 1 && itemList.getProject_id() == 1) {
            itemList.setStatus(1);
        }
        if (itemListService.update(itemList) > 0 ) {
            return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.COMMON_FAIL);

    }

}
