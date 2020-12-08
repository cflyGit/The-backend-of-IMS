package com.bupt.ims.controller;

import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.entity.ItemList;
import com.bupt.ims.service.ItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itemList")
public class ItemListController {
    @Autowired
    private ItemListService itemListService;

    @PostMapping("insert")
    @ResponseBody
    public JsonResult insert(@RequestBody ItemList itemList) {
        int res = itemListService.insert(itemList);
        if (res > 0) {
            return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.UPLOAD_ERROR);
    }

    @PostMapping("update")
    @ResponseBody
    public JsonResult update(@RequestBody ItemList itemList) {
        int res = itemListService.update(itemList);
        if (res > 0) {
            return ResultTool.success();
        }
        return ResultTool.fail(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("findByProjectId/{id}")
    @ResponseBody
    public JsonResult findByProjectId(@PathVariable("id") long id) {
        List<ItemList> itemList = itemListService.findByProjectId(id);
        if (itemList != null) {
            return ResultTool.success(itemList);
        }
        return ResultTool.fail(ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByInternsId/{id}")
    @ResponseBody
    public JsonResult findByInternsId(@PathVariable("id") long id) {
        List<ItemList> itemList = itemListService.findByInternsId(id);
        if (itemList != null) {
            return ResultTool.success(itemList);
        }
        return ResultTool.fail(ResultCode.QUERY_EMPTY);
    }

    @GetMapping("findByName/{name}")
    @ResponseBody
    public JsonResult findByInternsName(@PathVariable("name") String name) {
        List<IntershipProject> intershipProjectList = itemListService.findByInternsName(name);
        if (intershipProjectList != null) {
            return ResultTool.success(intershipProjectList);
        }
        return ResultTool.fail(ResultCode.QUERY_EMPTY);
    }

    @GetMapping("getItemList/{status}")
    @ResponseBody
    public JsonResult getItemList(@PathVariable("status") int status) {
        List<IntershipProject> intershipProjectList = itemListService.getItemList(status);
        if (intershipProjectList != null) {
            return ResultTool.success(intershipProjectList);
        }
        return ResultTool.fail(ResultCode.QUERY_EMPTY);
    }
}
