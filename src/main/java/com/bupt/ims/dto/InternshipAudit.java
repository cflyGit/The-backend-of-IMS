package com.bupt.ims.dto;

import com.bupt.ims.entity.ItemList;
import com.bupt.ims.entity.Project;

import java.io.Serializable;

public class InternshipAudit implements Serializable {
    private long order_id;
    private long project_id;
    private String project_name;
    private String student_name;
    private String base;
    private String leader;
    private String address;
    private int number;
    private int recorded;
    private String tags;
    private String info;
    private int status;

    private String file;
    private int school_audit;
    private int base_audit;
    private int tutor1_audit;
    private int tutor2_audit;

    public InternshipAudit(Project project, ItemList itemList, String student_name) {
        this.order_id = itemList.getOrder_id();
        this.project_id = project.getProject_id();
        this.project_name = project.getName();
        this.student_name = student_name;
        this.base = project.getBase();
        this.leader = project.getBase();
        this.address = project.getAddress();
        this.number = project.getNumber();
        this.recorded = project.getRecorded();
        this.tags = project.getTags();
        this.info = project.getInfo();
        this.status = project.getStatus();
        this.file = itemList.getFile();
        this.school_audit = itemList.getSchool_audit();
        this.base_audit = itemList.getSchool_audit();
        this.tutor1_audit = itemList.getTutor1_audit();
        this.tutor2_audit = itemList.getTutor2_audit();
    }

    public long getProject_id() {
        return project_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRecorded() {
        return recorded;
    }

    public void setRecorded(int recorded) {
        this.recorded = recorded;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        return "InternshipAudit{" +
                "order_id=" + order_id +
                ", project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", base='" + base + '\'' +
                ", leader='" + leader + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", recorded=" + recorded +
                ", tags='" + tags + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", file='" + file + '\'' +
                ", school_audit=" + school_audit +
                ", base_audit=" + base_audit +
                ", tutor1_audit=" + tutor1_audit +
                ", tutor2_audit=" + tutor2_audit +
                '}';
    }
}
