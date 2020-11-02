package com.bupt.ims.common.lang;

/**
 * @uthor lyfei
 * 定义返回码
 * rule：
 * 200: 成功
 * 1000~1999 参数错误
 * 2001~2999 用户错误
 * 3001~3999 接口异常
 */
public enum ResultCode {
    /* 成功 */
    SUCCESS(200, "成功"),
    LOGOUT_SUCCESS(201, "登出成功"),
//    QUERY_SUCCESS(202, "完成"),

    COMMON_FAIL(999, "失败"),

    /* 业务错误 */
    NO_PERMISSION(403, "没有权限"),

    /* 参数错误 1000~1500 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /* 交互(增删改查)错误 1500 - 1999*/
    FILE_FORMAT_ERROR(1505, "文件格式不正确"),
    FILE_ERROR_LINE(1506,"出错行数"),
    UPLOAD_ERROR(1507, "提交失败"),
    DELETE_ERROR(1508,"删除失败"),
    UPDATE_ERROR(1509, "修改失败"),
    QUERY_EMPTY(1510, "查询为空"),
    OPERATE_ERROR(1511, "操作失败"),

    /* 用户错误 2000-2999 */
    USER_COMMON_ERROR(2000, "用户错误"),
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    USER_OR_PASSWORD_ERROR(2010, "用户名或密码错误"),

    /* 查询结果 3000-3999*/
    ;

    private Integer code;
    private String msg;
    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
