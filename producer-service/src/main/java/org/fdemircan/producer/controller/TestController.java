package org.fdemircan.producer.controller;

import org.fdemircan.core.feigns.models.KafkaSendModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    private final KafkaTemplate<String ,KafkaSendModel> kafkaTemplate;


    public TestController(KafkaTemplate<String, KafkaSendModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping("/mess")
    public void sendMessage(){
        KafkaSendModel kafkaSendModel = new KafkaSendModel();
        kafkaSendModel.setMyName("Fırat DEMİRCAN");
        kafkaSendModel.setMyCode("02010333001");

        kafkaTemplate.send("topic",kafkaSendModel);
    }
}
