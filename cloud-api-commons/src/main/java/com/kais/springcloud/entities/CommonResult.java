package com.kais.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuxiankai
 * @ClassName CommonResult
 * @CreateTime 2021-09-09 11:49
 * @Description: json统一信息返回
 * 1.前端进行操作后得到的统一回复类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
