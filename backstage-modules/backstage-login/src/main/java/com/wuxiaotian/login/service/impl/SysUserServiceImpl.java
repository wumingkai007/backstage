package com.wuxiaotian.login.service.impl;

import com.wuxiaotian.login.jwtconfig.JwtTokenUtils;
import com.wuxiaotian.login.jwtconfig.JwtUser;
import com.wuxiaotian.login.service.ISysUserService;
import com.wuxiaotian.user.entity.SysUser;
import com.wuxiaotian.user.mapper.SysUserMapper;
import com.wuxiaotian.user.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wumingkai
 * @since 2020-04-06
 */
@Service
@Slf4j
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

   /*
    @Autowired
    @Lazy
    private RedisTemplate<String, Object> redisTemplate;

    private BoundHashOperations<String, String, Object> tokenStorage() {
        return redisTemplate.boundHashOps(jwtTokenUtils.getTokenHeader());
    }*/

    @Override
    public JwtUser validateUsername(String username) throws AuthenticationException {
        JwtUser jwtUser =  (JwtUser) jwtUserDetailsService.loadUserByUsername(username);
        if (jwtUser == null || jwtUser.getUsername()==null) {
            throw new RuntimeException("当前登录用户不存在");
        }
        return jwtUser;
    }

    @Override
    public String JwtToken(UserModel userModel) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userModel.getAccount(), userModel.getPassword());
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser userDetails = (JwtUser) jwtUserDetailsService.loadUserByUsername(userModel.getAccount());
        String token = jwtTokenUtils.generateToken(userDetails);
        log.debug("userDetails: {}", userDetails);
        return token;
    }

    @Override
    public SysUser findUser(String account) {
        SysUser sysUser = sysUserMapper.findUser(account);
        return sysUser;
    }
}
