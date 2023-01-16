package com.example.demo.sweater.controllers;

import com.example.demo.sweater.models.Message;
import com.example.demo.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/sweter")
public class GreetingController {
    @Autowired
    private MessageRepository messageRepo;


    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "sweter/main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String teg, Map<String, Object> model) {
        Message message = new Message(text, teg);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "sweter/main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findMessageByTeg(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "sweter/main";
    }
}
