package org.fdemircan.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.fdemircan.core.feigns.models.KafkaSendModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeKafkaTopic {


    @KafkaListener(topics = "topic",groupId = "myTmoGroup")
    public void consume(Object changes) throws JsonProcessingException {
        ConsumerRecord<String, KafkaSendModel> recodr= (ConsumerRecord<String, KafkaSendModel>) changes;
        System.out.println(recodr.value());

    }


}
