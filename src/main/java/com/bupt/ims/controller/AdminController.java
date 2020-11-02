package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("index")
    public JsonResult index() {
        return ResultTool.success(ResultCode.SUCCESS);
    }

    @PostMapping("upload/tutor")
    @ResponseBody
    public JsonResult uploadTutor(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        return adminService.account2DataBase(file, "Tutor");
    }

    @PostMapping("upload/student")
    @ResponseBody
    public JsonResult uploadStudent(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        return adminService.account2DataBase(file, "Student");
    }

    @PostMapping("upload/base")
    @ResponseBody
    public JsonResult uploadBase(@RequestParam("uploadFile")  MultipartFile file) throws IOException {
        return adminService.account2DataBase(file, "Base");
    }

//    @PostMapping("login")
//    @ResponseBody
//    public Result login(@RequestBody User loginDto) {
//        boolean res = adminService.login(loginDto.getId(), loginDto.getPassword());
//        System.out.println("res" + res);
//        if (res) {
//            return Result.success(null);
//        }
//        return Result.fail("用户名或密码错误");
//    }
}
