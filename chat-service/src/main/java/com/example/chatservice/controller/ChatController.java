package com.example.chatservice.controller;

import com.example.chatservice.model.Chat;
import com.example.chatservice.model.Message;
import com.example.chatservice.producer.MessageProducer;
import com.example.chatservice.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.createChat(chat);
    }

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/{chatId}/messages")
    public Message sendMessage(@PathVariable Long chatId, @RequestBody Message message) {
        message.setChatId(chatId);
        messageProducer.sendMessage(message.getContent());  // Gửi tin nhắn đến RabbitMQ
        return chatService.sendMessage(message);
    }
}
