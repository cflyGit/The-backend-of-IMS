package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.entity.Audit;
import com.bupt.ims.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("audit")
public class AuditController {
    @Autowired
    private AuditService auditService;

    @PostMapping("update")
    @ResponseBody
    public JsonResult updateAudit(@RequestBody Audit audit) {
        int res = auditService.update(audit);
        if (res > 0) {
            return ResultTool.success();
        }else {
            return ResultTool.fail(ResultCode.UPLOAD_ERROR);
        }
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public JsonResult findById(@PathVariable("id") long id){
        Audit audit = auditService.findById(id);
        if (audit != null) {
            return ResultTool.success(audit);
        }
        return ResultTool.fail(ResultCode.QUERY_EMPTY);
    }

    @PostMapping("statusBack")
    @ResponseBody
    public JsonResult statusBack(@RequestBody Audit audit) {
        if (auditService.statusBack(audit) > 0) {
            return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.OPERATE_ERROR);
    }
}
