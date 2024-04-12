package com.asiangrocery;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import java.util.Random;

/**
 * This class represents a service that produces transaction data to a Kafka topic.
 * It simulates transaction events and sends them to the 'transactions' topic.
 */
public class TransactionService {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        Random rand = new Random();

        // Simulate transactions
        for (int i = 0; i < 100; i++) {
            int customerID = rand.nextInt(1000);
            double amount = rand.nextDouble() * 100;
            String transaction = "{\"customerID\": \"" + customerID + "\", \"amount\": \"" + amount + "\"}";
            producer.send(new ProducerRecord<>("transactions", String.valueOf(customerID), transaction));
        }
        producer.close();
    }
}
