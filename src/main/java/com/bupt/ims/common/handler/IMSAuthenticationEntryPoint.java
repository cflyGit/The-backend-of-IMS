package com.bupt.ims.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class IMSAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult res;
//        String err = e.getMessage();
//        System.out.println(err);
//        if (e.getMessage().equals(ResultCode.USER_NOT_LOGIN.getCode().toString())){
//            res = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
//        }else if (e.getMessage().equals(ResultCode.USER_ACCOUNT_NOT_EXIST.getCode().toString())){
//            res = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
//        }else {
//            res = ResultTool.fail(ResultCode.USER_COMMON_ERROR);
//        }
        res = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
        httpServletResponse.setContentType("Application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSON(res).toString());
    }
}
