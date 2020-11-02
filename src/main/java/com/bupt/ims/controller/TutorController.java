package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.entity.Student;
import com.bupt.ims.entity.Tutor;
import com.bupt.ims.service.TutorService;
import org.apache.poi.ss.formula.functions.T;
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
    public JsonResult update(@RequestBody Tutor tutor) {
        return checkRes(tutorService.update(tutor) > 0, ResultCode.UPDATE_ERROR);
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") String id) {
        return checkRes(tutorService.deleteOne(id), ResultCode.DELETE_ERROR);
    }

    @PostMapping("insert")
    @ResponseBody
    public JsonResult inesrt(@RequestBody Tutor tutor) {
        return checkRes(tutorService.insert(tutor), ResultCode.UPDATE_ERROR);
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public JsonResult findById(@PathVariable("id") String id) {
        return checkRes(tutorService.findById(id), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public JsonResult findByName(@PathVariable("name") String name) {
        List<Tutor> tutors = tutorService.findByName(name);
        return checkRes(tutors, ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByAcademy/{academy}")
    @ResponseBody
    public JsonResult findByAcademy(@PathVariable("academy") String academy) {
        List<Tutor> tutors = tutorService.findByAcademy(academy);
        return checkRes(tutors, ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByAge/{age}")
    @ResponseBody
    public JsonResult findByAge(@PathVariable("age") int age) {
        List<Tutor> tutors = tutorService.findByAge(age);
        return checkRes(tutors, ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByPhone/{phone}")
    @ResponseBody
    public JsonResult findByPhone(@PathVariable("phone") String phone) {
        return checkRes(tutorService.findByPhone(phone), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByQQ/{qq}")
    @ResponseBody
    public JsonResult findByQQ(@PathVariable("qq") String qq) {
        return checkRes(tutorService.findByQQ(qq), ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByEmail/{email")
    @ResponseBody
    public JsonResult findByEmail(@PathVariable("email") String email) {
        return checkRes(tutorService.findByEmail(email), ResultCode.QUERY_EMPTY);
    }

    private JsonResult checkRes(List<Tutor> tutors, ResultCode rc) {
        if (tutors.size() > 0) {
            return ResultTool.success(tutors);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(boolean flag, ResultCode rc) {
        if (flag) {
            return ResultTool.success(null);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(Tutor tutor, ResultCode rc) {
        if (tutor!= null) {
            return ResultTool.success(tutor);
        }
        return ResultTool.fail(rc);
    }
}
