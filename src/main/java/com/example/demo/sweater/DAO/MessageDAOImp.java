package com.example.demo.sweater.DAO;

import com.example.demo.sweater.models.Message;
import com.example.demo.sweater.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageDAOImp implements MessageDAO{

    private final MessageRepository repository;

    @Override
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    @Override
    public Message getMessageByID(Long id) {
        return repository.findMessageById(id);
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }

    @Override
    public List<Message> findMessageByTeg(String tag) {
        return repository.findMessageByTeg(tag);
    }

}
