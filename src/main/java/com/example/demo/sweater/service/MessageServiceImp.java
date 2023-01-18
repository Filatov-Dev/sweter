package com.example.demo.sweater.service;

import com.example.demo.sweater.DAO.MessageDAO;
import com.example.demo.sweater.models.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService{
    private final MessageDAO messageDAO;

    @Override
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    @Override
    public Message getMessageByID(Long id) {
        return messageDAO.getMessageByID(id);
    }

    @Override
    public void saveMessage(Message message) {
        messageDAO.saveMessage(message);
    }

    @Override
    public List<Message> findMessageByTeg(String tag) {
        return messageDAO.findMessageByTeg(tag);
    }
}
