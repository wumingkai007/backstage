package com.wuxiaotian.user.model;

import lombok.Data;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/4/19 11:28
 * @Modified By：
 */
@Data
public class UserModel {

    //用户名
    private String account;
    //密码
    private String password;

    private Integer id;
}
