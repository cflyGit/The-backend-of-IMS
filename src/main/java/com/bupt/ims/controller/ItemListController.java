package com.bupt.ims.controller;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.Result;
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
    public Result insert(@RequestBody ItemList itemList) {
        int res = itemListService.insert(itemList);
        if (res > 0) {
            return Result.success(null);
        }
        return Result.fail("操作失败，请稍后再试");
    }

    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody ItemList itemList) {
        int res = itemListService.update(itemList);
        if (res > 0) {
            return Result.success(null);
        }
        return Result.fail("操作失败, 请稍后再试");
    }

    @GetMapping("findByProjectId/{id}")
    @ResponseBody
    public Result findByProjectId(@PathVariable("id") long id) {
        List<ItemList> itemList = itemListService.findByProjectId(id);
        if (itemList != null) {
            return Result.success(itemList);
        }
        return Result.fail("操作失败，请稍后再试");
    }

    @GetMapping("findByInternsId/{id}")
    @ResponseBody
    public Result findByInternsId(@PathVariable("id") long id) {
        List<ItemList> itemList = itemListService.findByInternsId(id);
        if (itemList != null) {
            return Result.success(itemList);
        }
        return Result.fail("操作失败，请稍后再试");
    }

    @GetMapping("getItemList/{status}")
    @ResponseBody
    public Result getItemList(@PathVariable("status") int status) {

        return null;
    }
}
