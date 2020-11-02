package com.bupt.ims.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult res;
        String err = e.getMessage();
        if (err.equals(ResultCode.USER_OR_PASSWORD_ERROR.getCode().toString())){
            res = ResultTool.fail(ResultCode.USER_OR_PASSWORD_ERROR);
        }else if (err.equals(ResultCode.USER_CREDENTIALS_ERROR.getCode().toString())){
            res = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        }else if (err.equals(ResultCode.USER_ACCOUNT_NOT_EXIST.getCode().toString())) {
            res = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else {
            res = ResultTool.fail(ResultCode.USER_COMMON_ERROR);
        }
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("code", "10001");
//        map.put("msg", e.getMessage());
//        map.put("msg_", "登录失败");
        httpServletResponse.setContentType("Application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSON(res).toString());
    }
}
