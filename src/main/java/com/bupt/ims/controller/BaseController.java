package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.entity.Base;
import com.bupt.ims.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("base")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @PostMapping("insert")
    @ResponseBody
    public Result insert(@RequestBody Base base){
        return checkRes(baseService.insert(base)>0, "提交失败，请稍后再试！");
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id") long id){
        return checkRes(baseService.deleteOne(id) > 0, "删除失败，请稍后再试");
    }

    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody Base base) {
        return checkRes(baseService.update(base)>0, "修改失败，请稍后再试！");
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public Result findByName(@PathVariable("name") String name) {
        return checkRes(baseService.findByName(name));
    }

    private Result checkRes(List<Base> bases) {
        if (bases.size() > 0) {
            return Result.success(bases);
        }
        return Result.fail("无");
    }

    private Result checkRes(boolean flag, String msg) {
        if (flag) {
            return Result.success(null);
        }
        return Result.fail(msg);
    }

    private Result checkRes(Base base) {
        if (base != null) {
            return Result.success(base);
        }
        return Result.fail("无查询结果");
    }
}
