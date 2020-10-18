package com.bupt.ims.entity;

import java.io.Serializable;

public class Audit implements Serializable {
    private long project_id;
    private String application_comments;
    private String application_reviewer;
    private String audit_comments;
    private String audit_reviewer;
    private String signed_comments;
    private String signed_reviewer;
    private String publish_comments;
    private String publish_reviewer;
    private String finished_comments;
    private String finished_reviewer;

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getApplication_comments() {
        return application_comments;
    }

    public void setApplication_comments(String application_comments) {
        this.application_comments = application_comments;
    }

    public String getApplication_reviewer() {
        return application_reviewer;
    }

    public void setApplication_reviewer(String application_reviewer) {
        this.application_reviewer = application_reviewer;
    }

    public String getAudit_comments() {
        return audit_comments;
    }

    public void setAudit_comments(String audit_comments) {
        this.audit_comments = audit_comments;
    }

    public String getAudit_reviewer() {
        return audit_reviewer;
    }

    public void setAudit_reviewer(String audit_reviewer) {
        this.audit_reviewer = audit_reviewer;
    }

    public String getSigned_comments() {
        return signed_comments;
    }

    public void setSigned_comments(String signed_comments) {
        this.signed_comments = signed_comments;
    }

    public String getSigned_reviewer() {
        return signed_reviewer;
    }

    public void setSigned_reviewer(String signed_reviewer) {
        this.signed_reviewer = signed_reviewer;
    }

    public String getPublish_comments() {
        return publish_comments;
    }

    public void setPublish_comments(String publish_comments) {
        this.publish_comments = publish_comments;
    }

    public String getPublish_reviewer() {
        return publish_reviewer;
    }

    public void setPublish_reviewer(String publish_reviewer) {
        this.publish_reviewer = publish_reviewer;
    }

    public String getFinished_comments() {
        return finished_comments;
    }

    public void setFinished_comments(String finished_comments) {
        this.finished_comments = finished_comments;
    }

    public String getFinished_reviewer() {
        return finished_reviewer;
    }

    public void setFinished_reviewer(String finished_reviewer) {
        this.finished_reviewer = finished_reviewer;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "project_id=" + project_id +
                ", application_comments='" + application_comments + '\'' +
                ", application_reviewer='" + application_reviewer + '\'' +
                ", audit_comments='" + audit_comments + '\'' +
                ", audit_reviewer='" + audit_reviewer + '\'' +
                ", signed_comments='" + signed_comments + '\'' +
                ", signed_reviewer='" + signed_reviewer + '\'' +
                ", publish_comments='" + publish_comments + '\'' +
                ", publish_reviewer='" + publish_reviewer + '\'' +
                ", finished_comments='" + finished_comments + '\'' +
                ", finished_reviewer='" + finished_reviewer + '\'' +
                '}';
    }
}
