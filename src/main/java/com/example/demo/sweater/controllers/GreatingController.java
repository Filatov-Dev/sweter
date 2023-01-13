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
public class GreatingController {

    @Autowired
    private MessageRepository repository;

    @GetMapping("/greating")
    public String greating(@RequestParam(name="name", required = false, defaultValue = "World")
                               String name, Map<String, Object> model) {
        model.put("name", name);

        return "greetings";
    }

    @GetMapping()
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping()
    public String addMessage(Map<String, Object> model, @RequestParam String text, @RequestParam String teg){
        Message message = new Message(text,teg);
        repository.save(message);

        Iterable<Message> messages = repository.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(Map<String, Object> model, @RequestParam String filter) {
        Iterable<Message> messages = repository.findMessageByTeg(filter);
        model.put("messages", messages);

        return "main";
    }
}
