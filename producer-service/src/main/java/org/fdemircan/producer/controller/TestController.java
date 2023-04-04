package org.fdemircan.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    private final KafkaTemplate<String ,Object> kafkaTemplate;


    public TestController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping("/mess")
    public void sendMessage(){

        kafkaTemplate.send("topic","Fırat DEMİRCAN 04-04-2023");
    }
}
