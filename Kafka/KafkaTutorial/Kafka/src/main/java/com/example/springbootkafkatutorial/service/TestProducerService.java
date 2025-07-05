package com.example.springbootkafkatutorial.service;

import com.example.springbootkafkatutorial.dto.TestMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TestProducerService {
    private final KafkaTemplate<String, TestMsg> kafkaTemplate;

    public CompletableFuture<String> sendMessage(TestMsg message) {
        return kafkaTemplate.send("my-topic", message)
                .thenApply(result -> {
                    System.out.println("메시지 전송 성공 : " + message);
                    System.out.println("Offset : " + result.getRecordMetadata().offset());
                    return "메시지 전송 성공";
                })
                .exceptionally(ex -> {
                    System.err.println("메시지 전송 실패 : " + ex.getMessage());
                    return "메시지 전송 실패";
                });
    }
}
