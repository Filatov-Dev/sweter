package com.example.demo.sweater.service;

import com.example.demo.sweater.models.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getAllMessages();
    public Message getMessageByID(Long id);
    public void saveMessage(Message message);
    public List<Message> findMessageByTeg(String tag);
}
