package com.example.demo.sweater.DAO;

import com.example.demo.sweater.models.Message;

import java.util.List;

public interface MessageDAO {
    public List<Message> getAllMessages();
    public Message getMessageByID(Long id);
    public void saveMessage(Message message);
    public List<Message> findMessageByTeg(String tag);
}
