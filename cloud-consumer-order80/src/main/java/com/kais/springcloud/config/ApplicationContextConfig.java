package com.kais.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liuxiankai
 * @ClassName ApplicationContextConfig
 * @CreateTime 2021-09-09 13:14
 * @Description: RestTemplate配置类
 * 1.(url, requestMap, ResponseBean.class)这三个参数分别代表
 * 2.REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 方法描述:
     * LoadBalanced注解：负载均衡，当80端口向（统一服务端口：cloud-order-service）服务提供者需求服务时
     *      并不知道询问那个端口（8001，8002），需要使用到LoadBalanced注解
     * 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，实现80端口随机访问8001或8002得到服务（轮询）
     *
     * @返回值 : org.springframework.web.client.RestTemplate
     * @作者 : lxk
     * 时间:2021/9/10 11:45
    */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
