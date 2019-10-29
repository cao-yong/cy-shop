package com.caoyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/28 19:46
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MallApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication.class, args);
    }
}
