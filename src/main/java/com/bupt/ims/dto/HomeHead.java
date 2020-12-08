package com.bupt.ims.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeHead implements Serializable {
    private List<String> info;
    private List<String> images;
    private List<IntershipProject> projects;

    public HomeHead() {
        info =  new ArrayList<>();
        images = new ArrayList<>();
        projects = new ArrayList<>();
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<IntershipProject> getProjects() {
        return projects;
    }

    public void setProjects(List<IntershipProject> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "HomeHead{" +
                "info=" + info +
                ", images=" + images +
                ", projects=" + projects +
                '}';
    }
}
