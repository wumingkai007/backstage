package com.wuxiaotian.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxiaotian.user.entity.SysUser;
import com.wuxiaotian.user.model.UserPageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/4/19 21:08
 * @Modified By：
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser findUser(@Param("account") String account);

    List<UserPageModel> selectListUser();
}
