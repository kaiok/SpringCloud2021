package com.kais.springcloud.service;

import com.kais.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author liuxiankai
 * @ClassName PaymentService
 * @CreateTime 2021-09-08 17:29
 * @Description: 支付模块Serivce
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
