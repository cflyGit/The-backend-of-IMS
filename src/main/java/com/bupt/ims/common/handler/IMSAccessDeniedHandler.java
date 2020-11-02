package com.bupt.ims.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 无权限
 */
@Component
public class IMSAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        JsonResult res = ResultTool.fail(ResultCode.NO_PERMISSION);
        httpServletResponse.setContentType("Application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSONObject.toJSON(res).toString());
    }
}
