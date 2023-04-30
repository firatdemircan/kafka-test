package org.fdemircan.kafka.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.fdemircan.core.feigns.models.KafkaSendModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaSendModel> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, KafkaSendModel> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, KafkaSendModel> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConst.KAFKA_URL);//find kafka in network
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "myTmoGroup");//go to this group id
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); //look for this key in this type
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaSendModel.class); //look for value is in this keype
        return new DefaultKafkaConsumerFactory<>(props); //send me back this properties
    }


}
