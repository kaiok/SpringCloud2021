package com.kais.springcloud.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liuxiankai
 * @ClassName MySelfRule
 * @CreateTime 2021-09-13 17:12
 * @Description: 修改ribbon默认算法轮询为随机
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        //定义为随机
        return new RandomRule();
    }
}