package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.entity.Base;
import com.bupt.ims.entity.Tutor;
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
    public JsonResult insert(@RequestBody Base base){
        return checkRes(baseService.insert(base), ResultCode.UPLOAD_ERROR);
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") String id){
        return checkRes(baseService.deleteOne(id), ResultCode.DELETE_ERROR);
    }

    @PostMapping("update")
    @ResponseBody
    public JsonResult update(@RequestBody Base base) {
        return checkRes(baseService.update(base)>0, ResultCode.UPDATE_ERROR);
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public JsonResult findByName(@PathVariable("name") String name) {
        return checkRes(baseService.findByName(name), ResultCode.QUERY_EMPTY);
    }

    private JsonResult checkRes(List<Base> bases, ResultCode rc) {
        if (bases.size() > 0) {
            return ResultTool.success(bases);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(boolean flag, ResultCode rc) {
        if (flag) {
            return ResultTool.success(null);
        }
        return ResultTool.fail(rc);
    }

    private JsonResult checkRes(Base base, ResultCode rc) {
        if (base!= null) {
            return ResultTool.success(base);
        }
        return ResultTool.fail(rc);
    }
}
