package com.example.monitoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class monitoringController {
    @GetMapping("/monitor")
    public String monitoring() {
        return "Monitoring";
    }
}
