package com.wuxiaotian.user.model;

import lombok.Data;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/5/4 15:52
 * @Modified By：
 */
@Data
public class UserPageModel {
    //用户账号
    private String account;

    //用户名
    private String userName;

    //账号状态
    private Integer userStatus;

    //年龄
    private String age;

    //性别
    private String gender;
    //密码
    private String passWord;

    //用户id
    private Integer userId;
}
