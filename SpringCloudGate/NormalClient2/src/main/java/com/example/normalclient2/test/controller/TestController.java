package com.example.normalclient2.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal1")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! - This is Normal Client 2 in 8083 Port";
    }
}
