package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.dto.LoginDto;
import com.bupt.ims.entity.Admin;
import com.bupt.ims.entity.Audit;
import com.bupt.ims.service.AdminService;
import com.bupt.ims.service.AuditService;
import com.bupt.ims.service.ProjectService;
import com.bupt.ims.service.TutorService;
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
    public String index() {
        return "ok";
    }

    @PostMapping("upload/tutor")
    @ResponseBody
    public Result uploadTutor(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        return adminService.account2DataBase(file, "Tutor");
    }

    @PostMapping("upload/student")
    @ResponseBody
    public Result uploadStudent(@RequestParam("uploadFile") MultipartFile file) throws IOException {
        return adminService.account2DataBase(file, "Student");
    }

    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestBody LoginDto loginDto) {
        boolean res = adminService.login(Long.parseLong(loginDto.getId()), loginDto.getPassword());
        System.out.println("res" + res);
        if (res) {
            return Result.success(null);
        }
        return Result.fail("用户名或密码错误");
    }
}
