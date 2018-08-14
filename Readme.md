Start zookeeper

```
cd /Users/Zoltan/apps/kafka_2.12-2.0.0
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start kafka server

```
cd /Users/Zoltan/apps/kafka_2.12-2.0.0

bin/kafka-server-start.sh config/server.properties
```

Create and list kafka topics
```
cd /Users/Zoltan/apps/kafka_2.12-2.0.0
bin/kafka-topics.sh --zookeeper localhost:2181 --create --replication-factor 1 --partitions 1 --topic test
bin/kafka-topics.sh --zookeeper localhost:2181 --list
```

Start a consumer
```
cd /Users/Zoltan/apps/kafka_2.12-0.10.2.0
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic bank-transfers --from-beginning

```


If we don't define 

```yaml
spring:
  kafka:
    producer:
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

we get 

```
org.apache.kafka.common.errors.SerializationException: Can't convert value of class com.example.BankTransfer to class org.apache.kafka.common.serialization.StringSerializer specified in value.serializer

```

Consumer conversion error:
```
Caused by: org.springframework.messaging.converter.MessageConversionException: Cannot convert from [java.lang.String] to [com.example.BankTransfer] for GenericMessage
```
