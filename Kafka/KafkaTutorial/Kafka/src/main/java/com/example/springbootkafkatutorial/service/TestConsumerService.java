package com.example.springbootkafkatutorial.service;

import com.example.springbootkafkatutorial.dto.TestMsg;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestConsumerService {

    @Getter
    private volatile TestMsg lastReceivedMsg;

    @KafkaListener(topics = "my-topic", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public void getMsg(TestMsg msg) {
        System.out.println("Received Message : " + msg);
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(TestMsg msg) {
        System.out.println("📥 수신된 메시지 : " + msg);
        this.lastReceivedMsg = msg;
    }
}
