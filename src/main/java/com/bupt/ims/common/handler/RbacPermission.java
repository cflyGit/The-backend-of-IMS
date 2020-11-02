package com.bupt.ims.common.handler;

import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.entity.Permission;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * RBAC数据模型控制权限
 * @author lyfei
 */
@Component("rbacPermission")
public class RbacPermission {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication auth) {
        Object principal = auth.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof IMSUser) {
            List<Permission> permissions = ((IMSUser)principal).getPermissions();
            for (Permission p : permissions) {
                if (antPathMatcher.match(p.getUrl(), request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
