package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
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
    public Result insert(@RequestBody Student student) {
        return checkRes(studentService.insert(student) > 0, "提交失败，请稍后再试");
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id) {
        return checkRes(studentService.deleteOne(id) > 0, "删除失败，请稍后重试");
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Result findById(@PathVariable("id") long id) {
        return checkRes(studentService.findById(id));
    }

    @GetMapping("findByAge/{age}")
    @ResponseBody
    public Result findByAge(@PathVariable("age") int age) {
        return checkRes(studentService.findByAge(age));
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public Result findByName(@PathVariable("name") String name) {
        List<Student> students = studentService.findByName(name);
        return checkRes(students);
    }

    @GetMapping("findByAcademy/{academy}")
    @ResponseBody
    public Result findByAcademy(@PathVariable("academy") String academy) {
        List<Student> students = studentService.findByAcademy(academy);
        return checkRes(students);
    }

    @GetMapping("findByPhone/{phone}")
    @ResponseBody
    public Result findByPhone(@PathVariable("phone") String phone) {
        return checkRes(studentService.findByPhone(phone));
    }

    @GetMapping("findByQQ/{qq}")
    @ResponseBody
    public Result findByQQ(@PathVariable("qq") String qq) {
        return checkRes(studentService.findByQQ(qq));
    }

    @GetMapping("findByEmail/{email")
    @ResponseBody
    public Result findByEmail(@PathVariable("email") String email) {
        return checkRes(studentService.findByEmail(email));
    }

    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody Student student) {
        return checkRes(studentService.update(student) > 0, "修改失败，请稍后再试");
    }

    private Result checkRes(List<Student> students) {
        if (students.size() > 0) {
            return Result.success(students);
        }
        return Result.fail("无");
    }

    private Result checkRes(boolean flag, String msg) {
        if (flag) {
            return Result.success(null);
        }
        return Result.fail(msg);
    }

    private Result checkRes(Student student) {
        if (student != null) {
            return Result.success(student);
        }
        return Result.fail("无查询结果");
    }
}
