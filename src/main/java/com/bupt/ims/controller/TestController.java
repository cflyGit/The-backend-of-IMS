package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("index")
    public JsonResult index(){
        return ResultTool.success();
    }
}
