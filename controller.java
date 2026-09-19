package com.example.calculator.controller;

import com.example.calculator.model.Calculation;
import com.example.calculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*") // Allows frontend to communicate with backend
public class CalculatorController {

    @Autowired
    private CalculationRepository repository;

    @PostMapping("/calculate")
    public Calculation calculate(@RequestBody CalculationRequest request) {
        String expression = request.getExpression();
        String result = evaluateExpression(expression);

        Calculation calculation = new Calculation(expression, result);
        return repository.save(calculation);
    }

    @GetMapping("/history")
    public List<Calculation> getHistory() {
        return repository.findAllByOrderByIdDesc();
    }

    // Basic evaluation logic (supports simple expressions safely)
    private String evaluateExpression(String expr) {
        try {
            // Using Nashorn or a simple parser; for production use a library like exp4j
            double result = new Object() {
                int pos = -1, ch;
                void next() { ch = (++pos < expr.length()) ? expr.charAt(pos) : -1; }
                boolean eat(int charToEat) {
                    while (ch == ' ') next();
                    if (ch == charToEat) { next(); return true; }
                    return false;
                }
                double parse() {
                    next();
                    double x = parseExpression();
                    if (pos < expr.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                    return x;
                }
                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if      (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }
                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if      (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('/')) x /= parseFactor(); // division
                        else return x;
                    }
                }
                double parseFactor() {
                    if (eat('+')) return parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus
                    double x;
                    int startPos = this.pos;
                    if (eat('(')) {
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                        while ((ch >= '0' && ch <= '9') || ch == '.') next();
                        x = Double.parseDouble(expr.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }
                    return x;
                }
            }.parse();
            
            // Format result to drop trailing .0 if integer
            if (result == (long) result) {
                return String.format("%d", (long) result);
            } else {
                return String.format("%s", result);
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}

class CalculationRequest {
    private String expression;
    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }
}
