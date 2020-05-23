package com.wuxiaotian.login.jwtconfig;

import com.wuxiaotian.login.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/4/6 21:36
 * @Modified By：
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private JwtAuthenticationFailure jwtAuthenticationFailure;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 获取 Request 中的请求头为 “ jwtToken ” 的 token 值
        String completeToken = httpServletRequest.getHeader(this.jwtTokenUtils.getTokenHeader());
        // 验证 值是否以"Bearer "开头
        if (completeToken != null) {
            // 根据 token值，获取 用户的 username
            String username = null;
            boolean booflag = jwtTokenUtils.isTokenExpired(completeToken);
            if(booflag){ // 过期了，重新刷选token，并在请求头中返回
                String newToken = jwtTokenUtils.refreshToken(completeToken);
                httpServletResponse.setHeader("newtoken",newToken);
                httpServletResponse.addHeader("Access-Control-Expose-Headers","newtoken");
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.setCharacterEncoding("UTF-8");
            }
            username = jwtTokenUtils.getUsernameFromToken(completeToken);

            log.debug("当前登录的用户是 : {} ", username);
            // 验证用户账号是否合法
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                JwtUser userDetails = null;
                try {
                    userDetails = sysUserService.validateUsername(username);
                } catch (AuthenticationException ex) {
                    log.debug(ex.getMessage());
                    SecurityContextHolder.clearContext();
                    this.jwtAuthenticationFailure.commence(httpServletRequest, httpServletResponse, ex);
                    return;
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                // 将用户信息，设置到 SecurityContext 中，可以在任何地方 使用 下面语句获取 获取 当前用户登录信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
