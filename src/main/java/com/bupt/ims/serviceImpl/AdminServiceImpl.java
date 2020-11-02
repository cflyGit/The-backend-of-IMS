package com.bupt.ims.serviceImpl;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.common.util.Excel2Entity;
import com.bupt.ims.common.util.FileManagement;
import com.bupt.ims.dao.AdminDao;
import com.bupt.ims.entity.*;
import com.bupt.ims.service.*;
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

    @Autowired
    private BaseService baseService;

    @Value("${entity.package}")
    private String entity_package;

    @Override
    public boolean login(String id, String password) {
        Admin _admin = adminDao.queryById(id);
        System.out.println(_admin);
        if (_admin != null && _admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public JsonResult account2DataBase(MultipartFile file, String entity){
        FileManagement fm = new FileManagement();

        String msg = "上传失败，请稍后再试";
        if (file == null) {
            return ResultTool.fail();
        }
        String fileName = file.getOriginalFilename().toLowerCase();
        String root = fm.mkdir("uploadFile") + File.separator + fileName;
        if (!(fileName.endsWith(".xlsx") || fileName.endsWith((".xls")))) {
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

        List<Integer> errorLine = Excel2DataBase(root, entity);
        if (errorLine == null) {
            return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.FILE_ERROR_LINE, errorLine);
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

    private boolean toSql(String entity, Object ea) {
        switch (entity) {
            case("Tutor") :
                return tutorService.insert((Tutor)ea);
            case("Student"):
                return studentService.insert((Student)ea);
            case("Base"):
                return baseService.insert((Base)ea);
            default:
                return false;
        }
    }
}
