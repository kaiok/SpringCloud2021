package com.kais.springcloud.Controller;

import com.kais.springcloud.entities.CommonResult;
import com.kais.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liuxiankai
 * @ClassName OrderController
 * @CreateTime 2021-09-09 13:17
 * @Description: 订单Order控制层
 * 1.使用RestTemplate进行接口功能的实现
 */

@RestController
public class OrderController {

    //单机版，服务访问IP地址写死/
    // private static final String PAYMENT_SRV_URL = "http://localhost:8001";

    /**
     * 方法描述:通过在eureka上注册过的微服务名称调用
     * 集群联机版
     *
    */
    private static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 方法描述:创建order订单
     * 客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
     * (url, requestMap, ResponseBean.class)这三个参数分别代表：REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
     * postForObject：返回对象为响应体中数据转化成的对象，基本上可以理解为Json
     * getForEntity：返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
     *
 * @param payment
     * @返回值 : com.kais.springcloud.entities.CommonResult
     * @作者 : lxk
     * 时间:2021/9/9 13:23
    */
    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_SRV + "/payment/create/" ,payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get{id}")
    public CommonResult getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_SRV + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id")
    public CommonResult getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_SRV + "/payment/get" + id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

}
