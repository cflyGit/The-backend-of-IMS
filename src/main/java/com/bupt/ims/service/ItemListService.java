package com.bupt.ims.service;

import com.bupt.ims.dto.InternshipAudit;
import com.bupt.ims.dto.IntershipProject;
import com.bupt.ims.entity._InternshipAudit;
import com.bupt.ims.entity.ItemList;

import java.util.List;

public interface ItemListService {
    int insert(ItemList itemList);

    int update(ItemList itemList);

    int findBy2Id(long project_id, long student_id);

    ItemList findByOrderId(long order_id);

    List<ItemList> findByProjectId(long id);

    List<ItemList> findByInternsId(long id);

    List<IntershipProject> findByInternsName(String name);

    int deleteByProjectId(long id);

    int deleteByInternsId(long id);

    List<IntershipProject> getItemList(int status);

    List<InternshipAudit> getItemListAudit(int status);

    List<InternshipAudit> getItemListAudit(String base_id);
}
