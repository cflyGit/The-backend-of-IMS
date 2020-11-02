package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.entity.Student;
import com.bupt.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("insert")
    @ResponseBody
    public JsonResult insert(@RequestBody Student student) {
        return checkRes(studentService.insert(student), ResultCode.UPLOAD_ERROR);
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") String id) {
        return checkRes(studentService.deleteOne(id), ResultCode.DELETE_ERROR);
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public JsonResult findById(@PathVariable("id") String id) {
        return checkRes(studentService.findById(id), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByAge/{age}")
    @ResponseBody
    public JsonResult findByAge(@PathVariable("age") int age) {
        return checkRes(studentService.findByAge(age), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public JsonResult findByName(@PathVariable("name") String name) {
        return checkRes(studentService.findByName(name), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByAcademy/{academy}")
    @ResponseBody
    public JsonResult findByAcademy(@PathVariable("academy") String academy) {
        List<Student> students = studentService.findByAcademy(academy);
        return checkRes(students, ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByPhone/{phone}")
    @ResponseBody
    public JsonResult findByPhone(@PathVariable("phone") String phone) {
        return checkRes(studentService.findByPhone(phone), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByQQ/{qq}")
    @ResponseBody
    public JsonResult findByQQ(@PathVariable("qq") String qq) {
        return checkRes(studentService.findByQQ(qq), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByEmail/{email")
    @ResponseBody
    public JsonResult findByEmail(@PathVariable("email") String email) {
        return checkRes(studentService.findByEmail(email), ResultCode.QUERY_EMPTY);
    }

    @PostMapping("update")
    @ResponseBody
    public JsonResult update(@RequestBody Student student) {
        return checkRes(studentService.update(student) > 0, ResultCode.UPDATE_ERROR);
    }

    private JsonResult checkRes(List<Student> students, ResultCode rc) {
        if (students.size() > 0) {
            return ResultTool.success(students);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(boolean flag, ResultCode rc) {
        if (flag) {
            return ResultTool.success(null);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(Student student, ResultCode rc) {
        if (student!= null) {
            return ResultTool.success(student);
        }
        return ResultTool.fail(rc);
    }
}
