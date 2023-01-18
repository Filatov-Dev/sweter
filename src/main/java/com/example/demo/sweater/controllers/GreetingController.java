package com.example.demo.sweater.controllers;

import com.example.demo.sweater.models.Message;
import com.example.demo.sweater.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/sweter")
@RequiredArgsConstructor
public class GreetingController {
    private final MessageService messageService;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageService.getAllMessages();

        model.put("messages", messages);

        return "sweter/main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String teg, Map<String, Object> model) {
        Message message = new Message(text, teg);

        messageService.saveMessage(message);

        Iterable<Message> messages = messageService.getAllMessages();

        model.put("messages", messages);

        return "sweter/main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageService.findMessageByTeg(filter);
        } else {
            messages = messageService.getAllMessages();
        }

        model.put("messages", messages);

        return "sweter/main";
    }
}
