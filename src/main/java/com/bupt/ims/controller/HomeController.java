package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.dto.HomeHead;
import com.bupt.ims.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("getHead")
    public JsonResult getHead(){
        HomeHead hh = homeService.getHead();
        if (hh == null) {
            return ResultTool.fail(ResultCode.QUERY_EMPTY);
        }
        return ResultTool.success(hh);
    }
}
