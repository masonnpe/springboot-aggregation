package com.masonnpe.springboot.rabbitmq;

import com.masonnpe.springboot.config.AccessInterceptor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MqController {
    @Autowired
    AmqpTemplate amqpTemplate;

    @GetMapping("id/{id}")
    public void getById(@PathVariable String id){
        String name = AccessInterceptor.getName();
        System.out.println(name);
        Map<String,String> map=new HashMap<>();
        map.put("id",id);
        map.put("name","jack");
        map.put("age","21");
        amqpTemplate.convertAndSend("shop.item.exchange","item.insert",map);// exchange key data
        amqpTemplate.convertAndSend("shop.item.exchange","item.delete",map);
    }
}
