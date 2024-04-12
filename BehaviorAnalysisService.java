package com.asiangrocery;

import org.apache.kafka.clients.consumer.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * This class represents a service that consumes transaction data from a Kafka topic.
 * It reads messages from the 'transactions' topic and prints them, simulating basic data analysis.
 */
public class BehaviorAnalysisService {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "behavior-analysis");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("transactions"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("Received transaction for customer %s: %s%n", record.key(), record.value());
            }
        }
    }
}
