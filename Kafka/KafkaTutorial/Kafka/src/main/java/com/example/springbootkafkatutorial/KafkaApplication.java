package com.example.springbootkafkatutorial;

import com.example.springbootkafkatutorial.dto.TestMsg;
import com.example.springbootkafkatutorial.service.TestProducerService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(TestProducerService producer) {
        return args -> {
            producer.sendMessage(new TestMsg("Hello Kafka!"));
        };
    }
}
