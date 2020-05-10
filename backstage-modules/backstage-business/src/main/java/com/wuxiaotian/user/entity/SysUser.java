package com.wuxiaotian.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wumingkai
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_USER")
public class SysUser extends Model<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名称
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @TableField("PASS_WORD")
    private String passWord;

    /**
     * 账号名
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 账号状态
     */
    @TableField("USER_STATUS")
    private Integer userStatus;

    //性别
    @TableField("gender")
    private String gender;

    //性别
    @TableField("age")
    private String age;
}
