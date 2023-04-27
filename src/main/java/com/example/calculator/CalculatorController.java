package com.example.calculator;

import com.example.calculator.model.Operation;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add/{a}/{b}")
    public ResponseEntity<Operation> add(@PathVariable double a, @PathVariable double b) {
        Operation operation = calculatorService.add(a, b);
        return ResponseEntity.ok(operation);
    }

    @GetMapping("/subtract/{a}/{b}")
    public ResponseEntity<Operation> subtract(@PathVariable double a, @PathVariable double b) {
        Operation operation = calculatorService.subtract(a, b);
        return ResponseEntity.ok(operation);
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<Operation> multiply(@PathVariable double a, @PathVariable double b) {
        Operation operation = calculatorService.multiply(a, b);
        return ResponseEntity.ok(operation);
    }

    @GetMapping("/divide/{a}/{b}")
    public ResponseEntity<Operation> divide(@PathVariable double a, @PathVariable double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        Operation operation = calculatorService.divide(a, b);
        return ResponseEntity.ok(operation);
    }
}