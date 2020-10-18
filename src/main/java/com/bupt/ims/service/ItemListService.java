package com.bupt.ims.service;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.entity.ItemList;

import java.util.List;

public interface ItemListService {
    int insert(ItemList itemList);

    int update(ItemList itemList);

    List<ItemList> findByProjectId(long id);

    List<ItemList> findByInternsId(long id);

    int deleteByProjectId(long id);

    int deleteByInternsId(long id);

    JSONObject getItemList(int status);
}
