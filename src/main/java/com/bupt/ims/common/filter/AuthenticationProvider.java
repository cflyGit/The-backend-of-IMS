package com.bupt.ims.common.filter;

import com.bupt.ims.common.lang.ResultCode;
import com.bupt.ims.entity.IMSUser;
import com.bupt.ims.serviceImpl.DataUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private DataUserDetailService dataUserDetailService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getName());
        String password = String.valueOf(authentication.getCredentials());

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BadCredentialsException(ResultCode.USER_OR_PASSWORD_ERROR.getCode().toString());
        }

        IMSUser imsUser = (IMSUser)dataUserDetailService.loadUserByUsername(username);
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        if (!encode.matches(password, imsUser.getPassword())) {
            throw new BadCredentialsException(ResultCode.USER_CREDENTIALS_ERROR.getCode().toString());
        }
        // 将用户信息放入全局SecurityContext中
        return this.createSuccessAuthentication(imsUser, authentication, imsUser);
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
