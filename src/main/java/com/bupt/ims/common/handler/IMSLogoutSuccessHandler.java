package com.bupt.ims.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class IMSLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JsonResult res = ResultTool.fail(ResultCode.LOGOUT_SUCCESS);
        httpServletResponse.setContentType("Application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSON(res).toString());
    }
}
