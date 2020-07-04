package com.wuxiaotian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: wumingkai
 * @Description:
 * @Date:Create：in 2020/3/28 21:52
 * @Modified By：
 */
@EnableTransactionManagement
@MapperScan("com.wuxiaotian.user.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
