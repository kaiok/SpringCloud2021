package com.kais.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author liuxiankai
 * @ClassName Payment
 * @CreateTime 2021-09-09 11:48
 * @Description: 订单支付实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * 数据库字段为bigint类型，实体类用Long类型
     */
    private Long id;
    private String serial;

}
