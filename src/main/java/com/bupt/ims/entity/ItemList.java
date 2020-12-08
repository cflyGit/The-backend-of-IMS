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

    private int school_audit;
    private int base_audit;
    private int tutor1_audit;
    private int tutor2_audit;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSchool_audit() {
        return school_audit;
    }

    public void setSchool_audit(int school_audit) {
        this.school_audit = school_audit;
    }

    public int getBase_audit() {
        return base_audit;
    }

    public void setBase_audit(int base_audit) {
        this.base_audit = base_audit;
    }

    public int getTutor1_audit() {
        return tutor1_audit;
    }

    public void setTutor1_audit(int tutor1_audit) {
        this.tutor1_audit = tutor1_audit;
    }

    public int getTutor2_audit() {
        return tutor2_audit;
    }

    public void setTutor2_audit(int tutor2_audit) {
        this.tutor2_audit = tutor2_audit;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "order_id=" + order_id +
                ", project_id=" + project_id +
                ", student_id=" + student_id +
                ", file='" + file + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", school_audit=" + school_audit +
                ", base_audit=" + base_audit +
                ", tutor1_audit=" + tutor1_audit +
                ", tutor2_audit=" + tutor2_audit +
                '}';
    }
}
