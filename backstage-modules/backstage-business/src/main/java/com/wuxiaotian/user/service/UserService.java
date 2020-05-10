package com.wuxiaotian.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuxiaotian.user.entity.SysUser;
import com.wuxiaotian.user.model.UserPageModel;

import java.util.List;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/5/4 16:05
 * @Modified By：
 */
public interface UserService extends IService<SysUser> {
    List<UserPageModel> selectListUser();

    void saveUser(UserPageModel userPageModel);

    void deleteUser(List<Integer> listUserId);
}
