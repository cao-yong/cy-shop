package com.caoyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/28 13:56
 * 内容管理相关服务
 **/
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.caoyong.sw.dao")
public class CmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsServiceApplication.class, args);
    }
}
