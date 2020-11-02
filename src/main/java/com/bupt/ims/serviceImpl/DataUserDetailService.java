package com.bupt.ims.serviceImpl;

import com.bupt.ims.common.lang.Result;
import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.dao.PermissionDao;
import com.bupt.ims.dao.RolePermissionDao;
import com.bupt.ims.dao.UserDao;
import com.bupt.ims.dao.UserRoleDao;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.entity.Permission;
import com.bupt.ims.entity.RolePermission;
import com.bupt.ims.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 用户认证
 */
@Service
public class DataUserDetailService implements UserDetailsService {

//    ProviderManager

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    RolePermissionDao rolePermissionDao;

    @Autowired
    PermissionDao permissiondao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || s.equals("")) {
            // 用户未登录
            throw new BadCredentialsException(ResultCode.USER_NOT_LOGIN.getCode().toString());
        }
        IMSUser user = userDao.findById(s);
        if (user == null) {
            // 用户不存在
            throw new BadCredentialsException(ResultCode.USER_ACCOUNT_NOT_EXIST.getCode().toString());
        }

        UserRole userRole = userRoleDao.findByUser(user.getUsername());
        List<RolePermission> rolePermissions = rolePermissionDao.findByRolePermission(userRole.getRole_id());
        Collection<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        List<Permission> permissions = new ArrayList<>();
        for (RolePermission rp: rolePermissions) {
            Permission p = permissiondao.findByPermission(rp.getPermission_id());
            permissions.add(p);
            authorities.add(new SimpleGrantedAuthority(p.getCode()));
        }
        return new IMSUser(user.getUsername(), user.getPassword(), authorities, userRole, permissions);
    }
}
