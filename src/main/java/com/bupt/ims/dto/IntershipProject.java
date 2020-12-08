package com.bupt.ims.dto;

import com.bupt.ims.entity.Project;

import java.io.Serializable;

public class IntershipProject implements Serializable {
    private long project_id;
    private String name;
    private String base;
    private String leader;
    private String address;
    private int number;
    private int recorded;
    private String tags;
    private String info;
    private int status;

    public IntershipProject(Project project) {
        this.project_id = project.getProject_id();
        this.name = project.getName();
        this.base = project.getBase();
        this.leader = project.getLeader();
        this.address = project.getLeader();
        this.number = project.getNumber();
        this.recorded = project.getRecorded();
        this.tags = project.getTags();
        this.info = project.getInfo();
        this.status = project.getStatus();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "IntershipProject{" +
                "project_id=" + project_id +
                ", name='" + name + '\'' +
                ", base='" + base + '\'' +
                ", leader='" + leader + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", recorded=" + recorded +
                ", tags='" + tags + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                '}';
    }
}
