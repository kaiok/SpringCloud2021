package com.kais.springcloud.controller;

import com.kais.springcloud.entities.CommonResult;
import com.kais.springcloud.entities.Payment;
import com.kais.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuxiankai
 * @ClassName PaymentController
 * @CreateTime 2021-09-08 17:33
 * @Description: 支付模块控制层
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 方法描述:服务发现，引入DiscoveryClient注解标签
     * 时间:2021/9/10 14:50
    */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 方法描述:插入数据
     *
 * @param payment
     * @返回值 : com.kais.springcloud.entities.CommonResult
     * @作者 : lxk
     * 时间:2021/9/8 21:46
     * 1.Order80模块中，controller层需要调用该模块的接口方法，参数需要加入@RequestBody注解
     * 进行修改的数据才能持久化到数据库中
    */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("==========插入操作返回结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,服务提供者端口为：" + serverPort);
        }else{
            return new CommonResult(444,"插入数据库失败,服务提供者端口为：" + serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("===============查询结果：{}",payment);
        log.info("热部署成功了！");
        if(payment != null){
            return new CommonResult<>(200,"success,服务提供端口为：" + serverPort,payment);
        }else{
            return new CommonResult<Payment>(444,"false" + id,null);
        }
    }

    /**
     * 方法描述:获取服务提供者提供的服务
     *
     * @返回值 : java.lang.Object
     * @作者 : lxk
     * 时间:2021/9/10 17:40
    */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取服务列表中的服务信息
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        //获取服务的实例（8001或者8002）
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUd-PAYMENT-SERVICE");
        for(ServiceInstance element : instances){
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }

        return this.discoveryClient;
    }

}
