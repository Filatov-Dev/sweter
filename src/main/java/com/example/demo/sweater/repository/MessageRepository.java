package com.example.demo.sweater.repository;

import com.example.demo.sweater.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public Message findMessageById(long id);
    public List<Message> findMessageByTeg(String teg);
}
