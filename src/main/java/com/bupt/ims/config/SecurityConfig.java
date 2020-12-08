package com.bupt.ims.config;

import com.bupt.ims.common.filter.AuthenticationProvider;
import com.bupt.ims.common.filter.IMSUsernamePasswordAuthenticationFilter;
import com.bupt.ims.common.filter.JwtAuthenticationTokenFilter;
import com.bupt.ims.common.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    String[] permitUrl = JwtAuthenticationTokenFilter.allUrl;

    @Resource
    private SuccessHandler successHandler;

    @Resource
    private FailureHandler failHandler;

    @Resource
    private IMSAuthenticationEntryPoint imsAuthenticationEntryPoint;

    @Resource
    private IMSLogoutSuccessHandler imsLogoutSuccessHandler;

    @Resource
    private IMSAccessDeniedHandler imsAccessDeniedHandler;

    @Resource
    private AuthenticationProvider authenticationProvider;

    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/login", "/index.html", "/static/**");
    }

    /**
     * 配置认证方式
     *  自动构建AuthenticationManager
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 方法一： 通过userDetailsService验证
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        // 方法二：通过authenticationProvider验证(保存用户信息到全局环境)
        auth.authenticationProvider(authenticationProvider);
    }

    //安全拦截

    /**
     * http 相关配置，包括：登入，登出，异常处理，会话管理
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 使用 JWT，关闭token
        http.formLogin().disable()
                .authorizeRequests()
                .antMatchers(permitUrl).permitAll()
                .anyRequest()
                .access("@rbacPermission.hasPermission(request, authentication)")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(imsLogoutSuccessHandler)
                .permitAll();

        // 登录逻辑重写覆盖UsernamePasswordAuthenticationFilter
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        //用户未登录
        http.httpBasic().authenticationEntryPoint(imsAuthenticationEntryPoint);
        http.exceptionHandling().accessDeniedHandler(imsAccessDeniedHandler);
//         执行IMSUsernamePasswordAuthentication 之前执行jwtAuthenticationTokenFilter
        http.addFilterBefore(jwtAuthenticationTokenFilter, IMSUsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    IMSUsernamePasswordAuthenticationFilter customAuthenticationFilter() throws Exception{
        IMSUsernamePasswordAuthenticationFilter filter = new IMSUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(successHandler);
        filter.setAuthenticationFailureHandler(failHandler);
        filter.setFilterProcessesUrl("/login");
        filter.setAuthenticationManager(this.authenticationManagerBean());
        return filter;

    }

}
