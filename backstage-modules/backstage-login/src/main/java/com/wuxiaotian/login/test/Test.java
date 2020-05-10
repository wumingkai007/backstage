package com.wuxiaotian.login.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/4/19 22:12
 * @Modified By：
 */
public class Test {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "456789";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}
