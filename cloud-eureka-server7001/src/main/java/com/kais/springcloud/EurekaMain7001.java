package com.kais.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author liuxiankai
 * @ClassName EurekaMain7001
 * @CreateTime 2021-09-09 15:24
 * @Description: Eureka服务中心
 * 1.需要先启动7001Eureka服务，再启动8001服务提供者模块
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaMain7001.class,args);

    }

}
