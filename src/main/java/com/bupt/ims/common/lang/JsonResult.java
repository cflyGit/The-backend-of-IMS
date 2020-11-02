package com.bupt.ims.common.lang;

import java.io.Serializable;

public class JsonResult implements Serializable {
    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Boolean success) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMsg() : ResultCode.COMMON_FAIL.getMsg();
    }

    public JsonResult(Boolean success, ResultCode res) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : (res.getCode());
        this.errorMsg = success ? ResultCode.SUCCESS.getMsg() : (res.getMsg());
    }

    public JsonResult(Boolean success, Object data) {
        this.success = success;
        this.errorCode = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.errorMsg = success ? ResultCode.SUCCESS.getMsg() : ResultCode.COMMON_FAIL.getMsg();
        this.data = data;
    }

    public JsonResult(ResultCode res, Object data) {
        this.success = false;
        this.errorCode = res.getCode();
        this.errorMsg = res.getMsg();
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
