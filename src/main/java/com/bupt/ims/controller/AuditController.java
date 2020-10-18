package com.bupt.ims.controller;

import com.bupt.ims.common.lang.Result;
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
    public Result updateAudit(@RequestBody Audit audit) {
        int res = auditService.update(audit);
        if (res > 0) {
            return Result.success(null);
        }else {
            return Result.fail("操作失败，请稍后再试！");
        }
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Result findById(@PathVariable("id") long id){
        Audit audit = auditService.findById(id);
        if (audit != null) {
            return Result.success(audit);
        }
        return Result.fail("查询结果不存在");
    }

    @PostMapping("statusBack")
    @ResponseBody
    public Result statusBack(@RequestBody Audit audit) {
        if (auditService.statusBack(audit) > 0) {
            return Result.success(null);
        }
        return Result.fail("操作失败，请稍后再试");
    }
}
