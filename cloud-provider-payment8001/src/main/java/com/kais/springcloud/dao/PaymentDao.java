package com.kais.springcloud.dao;

import com.kais.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author liuxiankai
 * @ClassName PaymentDao
 * @CreateTime 2021-09-08 16:40
 * @Description: 支付实体类Dao
 */
@Mapper
public interface PaymentDao {

    /**
     * 方法描述:创建支付订单
     *
 * @param payment
     * @返回值 : int
     * @作者 : lxk
     * 时间:2021/9/8 17:23
    */
    public int create(Payment payment);

    /**
     * 方法描述:根据ID查询支付订单
     *
     * @param id
     * @返回值 : com.kais.springcloud.entities.Payment
     * @作者 : lxk
     * 时间:2021/9/8 17:23
    */
    public Payment getPaymentById(@Param("id")Long id);

}
