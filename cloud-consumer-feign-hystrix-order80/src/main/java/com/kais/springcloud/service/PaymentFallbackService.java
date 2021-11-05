package com.kais.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author liuxiankai
 * @ClassName PaymentFallbackService
 * @CreateTime 2021-09-15 15:17
 * @Description: 实现了PaymentHystrixService接口
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
