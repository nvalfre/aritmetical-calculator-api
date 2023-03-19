package com.nv.aritmeticalcalculatorapi.controllers;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorResponse;
import com.nv.aritmeticalcalculatorapi.services.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController extends AbstractController{
    private final CalculatorService calculatorService;

    @PostMapping(path = "/{userName}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculatorResponse> calculate(@PathVariable String userName,
                                       @RequestBody CalculatorRequest calculatorRequest) {
        return ResponseEntity.ok(calculatorService.calculate(userName, calculatorRequest));
    }
}