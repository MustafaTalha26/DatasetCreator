package com.example.schema_validator.controller;

import com.example.schema_validator.models.StructuredSchema;
import com.example.schema_validator.service.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/schema")
@Validated
public class SchemaController {

    private final ValidationService validationService;

    public SchemaController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateSchema(
            @Valid @RequestBody StructuredSchema schema) {
        System.out.println("trying to validate");
        validationService.validateSchema(schema);

        return ResponseEntity.ok("Schema is valid");
    }
}

