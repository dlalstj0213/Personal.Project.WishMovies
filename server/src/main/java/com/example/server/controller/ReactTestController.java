package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactTestController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
