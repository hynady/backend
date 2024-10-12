package com.example.chatservice.service;

import com.example.chatservice.model.Chat;
import com.example.chatservice.model.Message;
import com.example.chatservice.repository.ChatRepository;
import com.example.chatservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
