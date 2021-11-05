package com.kais.springcloud.cfgbeans;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liuxiankai
 * @ClassName FeignConfig
 * @CreateTime 2021-09-14 15:31
 * @Description: Feign日志增强配置类
 */
@Configuration
public class FeignConfig
{
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
