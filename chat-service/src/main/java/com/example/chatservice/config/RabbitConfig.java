package com.example.chatservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfig {

    @Bean
    public Queue chatQueue() {
        return new Queue("chatQueue", true);
    }

    @Bean
    public Exchange chatExchange() {
        return new DirectExchange("chatExchange");
    }

    @Bean
    public Binding binding(Queue chatQueue, Exchange chatExchange) {
        return BindingBuilder.bind(chatQueue).to(chatExchange).with("chat.routing.key").noargs();
    }
}
