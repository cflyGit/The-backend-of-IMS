package com.bupt.ims.serviceImpl;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.util.Excel2Entity;
import com.bupt.ims.common.util.FileManagement;
import com.bupt.ims.dao.AdminDao;
import com.bupt.ims.entity.Admin;
import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.AdminService;
import com.bupt.ims.service.StudentService;
import com.bupt.ims.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private TutorService tutorService;

    @Autowired
    private StudentService studentService;

    @Value("${entity.package}")
    private String entity_package;

    @Override
    public boolean login(Long id, String password) {
        Admin _admin = adminDao.queryById(id);
        System.out.println(_admin);
        if (_admin != null && _admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Result account2DataBase(MultipartFile file, String entity){
        FileManagement fm = new FileManagement();

        String msg = "上传失败，请稍后再试";
        if (file == null) {
            return Result.fail(msg);
        }
        String fileName = file.getOriginalFilename().toLowerCase();
        String root = fm.mkdir("uploadFile") + File.separator + fileName;
        if (!(fileName.endsWith(".xlsx") || fileName.endsWith((".xls")))) {
            return Result.fail("文件格式不支持，请上传xls或xlsx文件");
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(root), false))){
            out.write(file.getBytes());
            out.flush();
        }catch (FileNotFoundException e) {
            return Result.fail("上传失败，文件不存在");
        }catch (IOException e) {
            return Result.fail(msg);
        }

        List<Integer> errorLine = Excel2DataBase(root, entity);
        if (errorLine == null) {
            return Result.success(null);
        }
        return Result.success(400, "错误行数", errorLine);
    }

    private List<Integer> Excel2DataBase(String file, String entity) {
        Excel2Entity<Object> e2e = new Excel2Entity<>(file, entity_package + "." + entity);
        ArrayList<Object> entities = e2e.transfer();

        ArrayList<Integer> errorLine = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            if(!toSql(entity, entities.get(i))) {
                errorLine.add(i);
            }
        }

        // 是否有错误的行
        if(errorLine.size() > 0)
            return errorLine;
        else
            return null;
    }

    private boolean toSql(String entity, Object object) {
        switch (entity) {
            case("Tutor") :
                return tutorService.insert((Tutor)object) > 0;
            case("Student"):
                return studentService.insert((Student)object) > 0;
            default:
                return false;
        }
    }
}
