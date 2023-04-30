package org.fdemircan.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.fdemircan.core.feigns.models.KafkaSendModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {



    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(){
        Map<String, Object> props = Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConst.KAFKA_URL, //look for kafka in network
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class, // look for key serializer
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaSendModel.class // look for value serializer
        );
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(props));
    }


    @Bean
    public DefaultKafkaProducerFactory<String, KafkaSendModel> defaultKafkaProducerFactory(){
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConst.KAFKA_URL);//find kafka in network
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "myTmoGroup");//go to this group id
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); //look for this key in this type
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaSendModel.class); //look for value is in this keype
        return new DefaultKafkaProducerFactory<>(props); //send me back this properties

    }



}
