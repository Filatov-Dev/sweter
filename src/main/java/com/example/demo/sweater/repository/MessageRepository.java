package com.example.demo.sweater.repository;

import com.example.demo.sweater.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public Message findMessageById(long id);
    public List<Message> findMessageByTeg(String teg);
}

