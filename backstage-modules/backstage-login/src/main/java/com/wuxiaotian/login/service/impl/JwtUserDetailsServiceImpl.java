package com.wuxiaotian.login.service.impl;

import com.wuxiaotian.login.jwtconfig.JwtUser;
import com.wuxiaotian.login.service.ISysUserService;
import com.wuxiaotian.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysUser sysUser= sysUserService.findUser(account);
        if(sysUser == null){
            throw  new RuntimeException("账号不存在");
        }
        return new JwtUser(sysUser.getUserId(), sysUser.getAccount(), sysUser.getPassWord(),sysUser.getUserStatus(), null);
    }


}
