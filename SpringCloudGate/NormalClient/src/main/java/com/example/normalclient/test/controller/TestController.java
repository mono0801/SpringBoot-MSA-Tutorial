package com.example.normalclient.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! This is Normal Client1";
    }

    @GetMapping("/str")
    public String str() {
        return "1";
    }
}
