package com.bupt.ims.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private long permission_id;
    private String code;
    private String url;

    public Permission(long permission_id, String code, String url) {
        this.permission_id = permission_id;
        this.code = code;
        this.url = url;
    }

    public long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(long permission_id) {
        this.permission_id = permission_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id=" + permission_id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
