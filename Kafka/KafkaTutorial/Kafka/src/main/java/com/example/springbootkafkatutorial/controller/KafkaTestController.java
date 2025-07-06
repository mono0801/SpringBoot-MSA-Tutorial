package com.example.springbootkafkatutorial.controller;

import com.example.springbootkafkatutorial.dto.TestMsg;
import com.example.springbootkafkatutorial.service.TestConsumerService;
import com.example.springbootkafkatutorial.service.TestProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class KafkaTestController {
    private final TestProducerService producerService;
    private final TestConsumerService consumerService;

    @PostMapping("/sync")
    public ResponseEntity<String> sendAndWait(@RequestBody TestMsg msg) {
        String result = producerService.sendMessage(msg).join();    // 동기 블로킹 처리
        return ResponseEntity.ok(result);
    }

    @PostMapping("/async")
    public ResponseEntity<String> asyncSend(@RequestBody TestMsg msg) {
        producerService.sendMessage(msg);
        return ResponseEntity.accepted().body("메시지 전송 성공");
    }

    @GetMapping("/latest")
    public ResponseEntity<TestMsg> getLatest() {
        TestMsg msg = consumerService.getLastReceivedMsg();

        if(msg == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(msg);
    }
}
