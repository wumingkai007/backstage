package com.wuxiaotian.login.service;

import com.wuxiaotian.login.jwtconfig.JwtUser;
import com.wuxiaotian.user.entity.SysUser;
import com.wuxiaotian.user.model.UserModel;
import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wumingkai
 * @since 2020-04-06
 */
public interface ISysUserService{
    /**
     * 校验登录的用户中，用户名，是否正确
     *
     * @param username 用户名
     * @return 操作结果
     * @throws AuthenticationException
     */
    JwtUser validateUsername(String username) throws AuthenticationException;

    String JwtToken (UserModel userModel);

    SysUser findUser(String account);
}
