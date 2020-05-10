package com.wuxiaotian.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuxiaotian.user.entity.SysUser;
import com.wuxiaotian.user.mapper.SysUserMapper;
import com.wuxiaotian.user.model.UserPageModel;
import com.wuxiaotian.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/5/4 16:05
 * @Modified By：
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public List<UserPageModel> selectListUser() {
        List<UserPageModel> list = sysUserMapper.selectListUser();
        return list;
    }

    @Override
    public void saveUser(UserPageModel userPageModel) {
        SysUser sysUser = new SysUser();
        sysUser.setAccount(userPageModel.getAccount());
        sysUser.setAge(userPageModel.getAge());
        sysUser.setGender(userPageModel.getGender());
        sysUser.setUserStatus(1);
        sysUser.setPassWord(encodePassword(userPageModel.getPassWord()));
        sysUser.setUserName(userPageModel.getUserName());
        sysUser.insert();
    }

    /**
     *删除用户
     * @param listUserId
     */
    @Override
    public void deleteUser(List<Integer> listUserId) {
        for (Integer integer : listUserId) {
            sysUserMapper.deleteById(integer);
        }
    }
}
