package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.util.Json2TimeStamp;
import com.bupt.ims.entity.Project;
import com.bupt.ims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody Project project) {
        return checkRes(projectService.insert(project) > 0, "提交失败，请稍后重试");
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Result findById(@PathVariable("id") long id) {
        return checkRes(projectService.findById(id));
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public Result findByName(@PathVariable("name") String name) {
        return checkRes(projectService.findByName(name));
    }

    @GetMapping("findByDate/{start}/{end}/{status}")
    @ResponseBody
    public Result findByDate(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("status") String status) throws ParseException {
        return checkRes(projectService.findByDate(Json2TimeStamp.transfer(start), Json2TimeStamp.transfer(end), status));
    }

    @GetMapping("findByStatus/{status}")
    @ResponseBody
    public Result findByStatus(@PathVariable("status") int status){
        return checkRes(projectService.findByStatus(status));
    }



    private Result checkRes(List<Project> projects) {
        if (projects.size() > 0) {
            return Result.success(projects);
        }
        return Result.fail("无");
    }

    private Result checkRes(boolean flag, String msg) {
        if (flag) {
            return Result.success(null);
        }
        return Result.fail(msg);
    }

    private Result checkRes(Project project) {
        if (project != null) {
            return Result.success(project);
        }
        return Result.fail("无查询结果");
    }
}
