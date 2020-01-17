package com.nagarro.nagp.mom;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="${nagp.queue.name}")
    public void receiveMessage(byte[] message) {
        System.out.println("Received <" + new String(message) + ">");
    }
}