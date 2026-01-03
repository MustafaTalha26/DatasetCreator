package com.example.schema_validator.producer;

import com.example.schema_validator.models.StructuredSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SchemaKafkaProducer {

    private final KafkaTemplate<String, StructuredSchema> kafkaTemplate;
    private final String topic;

    public SchemaKafkaProducer(
            KafkaTemplate<String, StructuredSchema> kafkaTemplate,
            @Value("${kafka.topic.structured-schema}") String topic) {

        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendSchema(StructuredSchema schema) {
        kafkaTemplate.send(topic, schema.getSchemaName(), schema);
    }
}



