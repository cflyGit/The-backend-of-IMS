package com.bupt.ims.dao;

import com.bupt.ims.entity.ItemList;

import java.util.List;

public interface ItemListDao {
    int insert(ItemList itemList);

    int update(ItemList itemList);

    int findBy2Id(long project_id, long student_id);

    ItemList findByOrderId(long order_id);

    List<ItemList> findByProjectId(long id);

    List<ItemList> findByInternsId(long id);

    int deleteByProjectId(long id);

    int deleteByInternsId(long id);
}
