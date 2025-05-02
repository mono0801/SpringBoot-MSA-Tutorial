package com.example.configclient1.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms1")
public class TestRestController {

    @Value("${TEST_VAR}")
    private String envStr;

    @GetMapping("/env")
    public String env() {
        return "환경변수 값 : " + envStr;
    }
}
