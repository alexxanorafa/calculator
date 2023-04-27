package com.example.calculator.service;

import com.example.calculator.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Operation add(double a, double b) {
        double result = a + b;
        return new Operation(a, b, "+", result);
    }

    public Operation subtract(double a, double b) {
        double result = a - b;
        return new Operation(a, b, "-", result);
    }

    public Operation multiply(double a, double b) {
        double result = a * b;
        return new Operation(a, b, "*", result);
    }

    public Operation divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = a / b;
        return new Operation(a, b, "/", result);
    }
}