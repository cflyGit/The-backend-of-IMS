package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody Tutor tutor) {
        return checkRes(tutorService.update(tutor) > 0, "修改失败，请稍后再试");
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id) {
        return checkRes(tutorService.deleteOne(id) > 0, "删除失败，请稍后重试");
    }

    @PostMapping("insert")
    @ResponseBody
    public Result inesrt(@RequestBody Tutor tutor) {
        return checkRes(tutorService.insert(tutor) > 0, "提交失败，请稍后重试");
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Result getById(@PathVariable("id") long id) {
        return checkRes(tutorService.findById(id));
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public Result getByName(@PathVariable("name") String name) {
        List<Tutor> tutors = tutorService.findByName(name);
        return checkRes(tutors);
    }

    @GetMapping("findByAcademy/{academy}")
    @ResponseBody
    public Result getByAcademy(@PathVariable("academy") String academy) {
        List<Tutor> tutors = tutorService.findByAcademy(academy);
        return checkRes(tutors);
    }

    @GetMapping("findByAge/{age}")
    @ResponseBody
    public Result getByAge(@PathVariable("age") int age) {
        List<Tutor> tutors = tutorService.findByAge(age);
        return checkRes(tutors);
    }

    private Result checkRes(List<Tutor> tutors) {
        if (tutors.size() > 0) {
            return Result.success(tutors);
        }
        return Result.fail("无");
    }

    private Result checkRes(boolean flag, String msg) {
        if (flag) {
            return Result.success(null);
        }
        return Result.fail(msg);
    }

    private Result checkRes(Tutor tutor) {
        if (tutor != null) {
            return Result.success(tutor);
        }
        return Result.fail("无查询结果");
    }
}
