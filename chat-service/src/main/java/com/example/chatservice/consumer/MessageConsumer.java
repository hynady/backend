package com.example.chatservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @RabbitListener(queues = "chatQueue")
    public void receiveMessage(String message) {
        // Xử lý tin nhắn nhận được
        System.out.println("Received Message: " + message);
    }
}
