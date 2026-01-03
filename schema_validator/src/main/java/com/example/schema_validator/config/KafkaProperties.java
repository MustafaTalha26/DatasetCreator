package com.example.schema_validator.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    // getters and setters
    private String bootstrapServers;
    private Producer producer = new Producer();

    public Map<String, Object> buildProducerProperties() {
        Map<String, Object> props = new HashMap<>();

        // basic bootstrap server
        props.put("bootstrap.servers", bootstrapServers);

        // key & value serializers
        props.put("key.serializer", producer.keySerializer);
        props.put("value.serializer", producer.valueSerializer);

        // add custom producer properties if any
        if (producer.getProperties() != null) {
            props.putAll(producer.getProperties());
        }

        return props;
    }

    @Setter
    @Getter
    public static class Producer {
        // getters and setters
        private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
        private String valueSerializer = "org.springframework.kafka.support.serializer.JsonSerializer";
        private Map<String, Object> properties = new HashMap<>();

    }
}

