package com.example.springbootkafkatutorial.service;

import com.example.springbootkafkatutorial.dto.TestMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public TestMsg getMsg(TestMsg msg) {
        System.out.println("Received Message : " + msg);
        return msg;
    }
}
