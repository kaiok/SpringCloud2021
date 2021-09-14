package com.kais.springcloud;

import com.kais.springcloud.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author liuxiankai
 * @ClassName OrderMain80
 * @CreateTime 2021-09-09 11:54
 * @Description: 客户端主启动类
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * 方法描述:将ribbon的负载均衡算法有轮询改为随机
*/
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class,args);

    }

}
