package com.example.demo.sweater.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/greating")
public class GreatingController {
    @GetMapping()
    public String greating(@RequestParam(name="name", required = false, defaultValue = "World")
                               String name, Map<String, Object> model) {
        model.put("name", name);
        return "greatings";
    }
}
