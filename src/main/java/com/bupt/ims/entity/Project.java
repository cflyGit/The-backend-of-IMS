package com.bupt.ims.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private long project_id;
    private String name;
    private String base;
    private String leader;
    private String address;
    private int number;
    private int recorded;
    private String tags;
    private String info;
    private String file;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date application_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date audit_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signed_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publish_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finished_time;

    /**
     * 项目状态：
     * 申请：0， 审核：1， 签订：2， 发布： 3， 结束：4,
     */
    private int status;

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getApplication_time() {
        return application_time;
    }

    public void setApplication_time(Date application_time) {
        this.application_time = application_time;
    }

    public Date getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }

    public Date getSigned_time() {
        return signed_time;
    }

    public void setSigned_time(Date signed_time) {
        this.signed_time = signed_time;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public Date getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(Date finished_time) {
        this.finished_time = finished_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", name='" + name + '\'' +
                ", base=" + base +
                ", leader='" + leader + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", recorded=" + recorded +
                ", tags='" + tags + '\'' +
                ", info='" + info + '\'' +
                ", file='" + file + '\'' +
                ", application_time=" + application_time +
                ", audit_time=" + audit_time +
                ", signed_time=" + signed_time +
                ", publish_time=" + publish_time +
                ", finished_time=" + finished_time +
                ", status=" + status +
                '}';
    }
}
