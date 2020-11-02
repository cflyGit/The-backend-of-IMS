package com.bupt.ims.common.lang;

import com.bupt.ims.common.util.Json2TimeStamp;

public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static JsonResult success(Object data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode res) {
        return new JsonResult(false, res);
    }

    public static JsonResult fail(ResultCode res, Object data) {
        return new JsonResult(res, data);
    }
}