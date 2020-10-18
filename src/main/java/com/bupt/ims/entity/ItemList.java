package com.bupt.ims.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ItemList implements Serializable {
    private long order_id;
    private long project_id;
    private long student_id;
    private String file;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    // status实习状态: 申请审批（audit)：0，签订协议： 1， 实习过程：2， 评定：3， 结束：4
    private int status;
}
