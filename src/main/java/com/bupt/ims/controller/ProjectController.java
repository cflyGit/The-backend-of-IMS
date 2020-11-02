package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.common.util.Json2TimeStamp;
import com.bupt.ims.entity.Project;
import com.bupt.ims.entity.Student;
import com.bupt.ims.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
    public JsonResult insert(@RequestBody Project project) {
        return checkRes(projectService.insert(project) > 0, ResultCode.UPLOAD_ERROR);
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public JsonResult findById(@PathVariable("id") long id) {
        return checkRes(projectService.findById(id), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public JsonResult findByName(@PathVariable("name") String name) {
        return checkRes(projectService.findByName(name), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByDate/{start}/{end}/{status}")
    @ResponseBody
    public JsonResult findByDate(@PathVariable("start") String start, @PathVariable("end") String end, @PathVariable("status") String status) throws ParseException {
        return checkRes(projectService.findByDate(Json2TimeStamp.transfer(start), Json2TimeStamp.transfer(end), status), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByStatus/{status}")
    @ResponseBody
    public JsonResult findByStatus(@PathVariable("status") int status){
        return checkRes(projectService.findByStatus(status), ResultCode.QUERY_EMPTY);
    }

    private JsonResult checkRes(List<Project> projects, ResultCode rc) {
        if (projects.size() > 0) {
            return ResultTool.success(projects);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(boolean flag, ResultCode rc) {
        if (flag) {
            return ResultTool.success(null);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(Project project, ResultCode rc) {
        if (project!= null) {
            return ResultTool.success(project);
        }
        return ResultTool.fail(rc);
    }
}
