package com.example.schema_validator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StructuredSchema {

    private String schemaName;           // e.g., "UserData"
    private int version;                 // schema version
    private List<Column> columns;        // list of columns in this schema
}
