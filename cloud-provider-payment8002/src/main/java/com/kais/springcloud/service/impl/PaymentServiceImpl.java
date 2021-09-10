package com.kais.springcloud.service.impl;

import com.kais.springcloud.dao.PaymentDao;
import com.kais.springcloud.entities.Payment;
import com.kais.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liuxiankai
 * @ClassName PaymentServiceImpl
 * @CreateTime 2021-09-08 17:31
 * @Description: Payment支付Service实现类
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
