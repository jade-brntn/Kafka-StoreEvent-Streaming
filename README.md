
# Asian Grocery Kafka Project

## Overview
This project simulates the generation and processing of transaction data for an Asian grocery store using Apache Kafka and Java. It includes services for producing and consuming transaction data to analyze customer behavior patterns.

## Prerequisites
- Java JDK 8 or later
- Apache Kafka
- Maven

## Setup and Running

### Kafka Setup
Start your Kafka and Zookeeper instances:

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

Create the necessary Kafka topics:

```bash
bin/kafka-topics.sh --create --topic transactions --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

### Building the Project
Navigate to the project directory and build the project using Maven:

```bash
mvn clean package
```

### Running the Services
Start the Transaction Service:

```bash
java -cp target/kafka-services-1.0-SNAPSHOT.jar com.asiangrocery.TransactionService
```

Start the Behavior Analysis Service in a new terminal:

```bash
java -cp target/kafka-services-1.0-SNAPSHOT.jar com.asiangrocery.BehaviorAnalysisService
```

## Description of Services
- **Transaction Service**: Produces simulated transaction data and sends it to the 'transactions' topic.
- **Behavior Analysis Service**: Consumes the transaction data from the 'transactions' topic and prints the transactions, demonstrating how data analysis might be conducted.

## Further Enhancements
- Integrate with real databases for storing transaction records.
- Implement more sophisticated analytics algorithms using stream processing frameworks.
- Enhance the security of Kafka communications.
