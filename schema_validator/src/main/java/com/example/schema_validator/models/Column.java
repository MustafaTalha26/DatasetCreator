package com.example.schema_validator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    private String name;        // Field name, e.g., "birthDate", "city"
    private String type;        // Data type, e.g., "String", "Double", "Date"
    private String format;      // How it should be stored, e.g., "String" even for dates
    private Object exampleValue; // Optional: example or fixed value
    private List<String> allowedValues; // For predefined random values like ["Ankara", "İzmir"]
    private Double minValue;    // For random doubles
    private Double maxValue;    // For random doubles
    //Offsetdatetime cant be serialized by jackson.
    private String minDate; // For random dates
    private String maxDate; // For random dates
}
