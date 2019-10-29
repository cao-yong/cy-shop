package com.caoyong.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/29 19:46
 * 网关服务
 **/
@SpringCloudApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
