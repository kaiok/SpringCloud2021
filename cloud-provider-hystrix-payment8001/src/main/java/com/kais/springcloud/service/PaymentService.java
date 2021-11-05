package com.kais.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author liuxiankai
 * @ClassName PaymentService
 * @CreateTime 2021-09-14 17:23
 * @Description: 业务层
 * 1.模拟故障的发生
 */
@Service
public class PaymentService {

    /**
     * 方法描述:正常访问，一切OK
     * 
 * @param id 
     * @返回值 : java.lang.String
     * @作者 : lxk
     * 时间:2021/9/14 17:39
    */
    public String paymentInfo_Ok(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Ok,id:" + id + "\t" + "0(^_^)0";
    }

    /**
     * 方法描述:一旦调用服务方法失败并抛出了错误信息后，
     * 会自动调用@HystrixCommand标注好的
     * fallbackMethod调用类中的指定方法:paymentInfo_TimeOutHandler
     *
 * @param id
     * @返回值 : java.lang.String
     * @作者 : lxk
     * 时间:2021/9/15 14:31
    */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })

    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id:" + id + "\t" + "0(^_^)0 ,耗费三秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }



}
