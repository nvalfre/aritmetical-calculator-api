package com.nv.aritmeticalcalculatorapi.controllers;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.exceptions.CalculatorException;
import com.nv.aritmeticalcalculatorapi.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> calculate(@PathVariable Long userId,
                                       @RequestBody CalculatorRequest calculatorRequest) {
        Double result = calculatorService.calculate(userId, calculatorRequest);
        return ResponseEntity.ok(result);
    }
}