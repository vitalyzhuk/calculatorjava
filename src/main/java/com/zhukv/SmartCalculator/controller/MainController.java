package com.zhukv.SmartCalculator.controller;

import com.zhukv.SmartCalculator.entity.CalculationsRequest;
import com.zhukv.SmartCalculator.entity.CalculationsResult;
import com.zhukv.SmartCalculator.logic.Calculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/calculate")
    public ResponseEntity<CalculationsResult> calculate(@RequestBody CalculationsRequest request) {
        Calculator calculator = new Calculator(request);
        return ResponseEntity.ok(calculator.calculate());
    }
}
