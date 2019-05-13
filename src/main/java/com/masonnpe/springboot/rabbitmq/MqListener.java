package com.masonnpe.springboot.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "shop.create.index.queue", durable = "true"),
            exchange = @Exchange(
                    value = "shop.item.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"item.insert", "item.update"}))
    public void listenCreate(Map map) throws Exception {
        if (map == null) {
            return;
        }
        System.out.println("create"+map.get("id"));
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "shop.delete.index.queue", durable = "true"),
            exchange = @Exchange(
                    value = "shop.item.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"item.delete"}))
    public void listenDelete(Map map) throws Exception {
        System.out.println("delete:"+map.get("id"));
    }

}
