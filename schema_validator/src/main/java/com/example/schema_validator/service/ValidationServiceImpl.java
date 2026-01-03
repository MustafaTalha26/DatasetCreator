package com.example.schema_validator.service;

import com.example.schema_validator.models.StructuredSchema;
import com.example.schema_validator.producer.SchemaKafkaProducer;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final SchemaKafkaProducer schemaKafkaProducer;

    public ValidationServiceImpl(SchemaKafkaProducer schemaKafkaProducer) {
        this.schemaKafkaProducer = schemaKafkaProducer;
    }

    @Override
    public void validateSchema(StructuredSchema schema) {

        if (schema.getColumns() == null || schema.getColumns().isEmpty()) {
            throw new IllegalArgumentException("Schema must contain at least one column");
        }

        schemaKafkaProducer.sendSchema(schema);
    }
}


