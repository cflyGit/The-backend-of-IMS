package com.bupt.ims.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.bupt.ims.common.lang.JsonResult;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.common.lang.ResultTool;
import com.bupt.ims.common.util.JwtTokenUtil;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.serviceImpl.DataUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final static String HEADER = "Authorization";
//    private final static String BEARER = "ims";

    public static String[] allUrl = new String[]{"/login", "/test/**"};

    @Autowired
    private DataUserDetailService dataUserDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        boolean boo = false;
        // arrUrl内的请求在此fileter上不进行操作
        for (String s : allUrl) {
            if (antPathMatcher.match(s, request.getRequestURI())) {
                boo = true;
                break;
            }
        }
        if (boo) {
            filterChain.doFilter(request, response);
            return ;
        }

        String header = request.getHeader(HEADER);
        // 未登录
        if (header == null){
            throw new BadCredentialsException(ResultCode.USER_NOT_LOGIN.getCode().toString());
        }

        final String authToken = header;
        if (JwtTokenUtil.isTokenExpired(authToken)) {
            getResponse(response, ResultTool.fail(ResultCode.USER_ACCOUNT_EXPIRED));
            return ;
        }

        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        if (StringUtils.isEmpty(username)) {
            getResponse(response, ResultTool.fail(ResultCode.USER_ACCOUNT_DISABLE));
            return ;
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            IMSUser imsUser = (IMSUser)dataUserDetailService.loadUserByUsername(username);
            if (imsUser != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(imsUser, null, imsUser.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private void getResponse(HttpServletResponse response, JsonResult jsonResult) throws IOException{
        response.setContentType("Application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSON(jsonResult).toString());
    }
}
