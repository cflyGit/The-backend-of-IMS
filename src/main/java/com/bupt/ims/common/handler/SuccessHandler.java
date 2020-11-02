package com.bupt.ims.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.util.JwtTokenUtil;
import com.bupt.ims.entity.IMSUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        IMSUser imsUser = (IMSUser)authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("code", String.valueOf(HttpServletResponse.SC_OK));
        map.put("msg", "登录成功");
        map.put("token", JwtTokenUtil.generateToken(imsUser));
        map.put("username", imsUser.getUsername());
        map.put("actor", imsUser.getUserRoles().getRole_id());

        httpServletResponse.setContentType("Application/json;charset=utf-8");
        Writer writer = httpServletResponse.getWriter();
        writer.write(JSONObject.toJSON(map).toString());
        writer.flush();
        writer.close();
    }
}
