package com.nv.aritmeticalcalculatorapi.controllers;

import com.google.gson.Gson;
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
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final Gson gson;

    @GetMapping(path = "/{userName}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calculate(@PathVariable String userName,
                                       @RequestBody CalculatorRequest calculatorRequest) {
        CalculatorResponse result = calculatorService.calculate(userName, calculatorRequest);
        return ResponseEntity.ok(gson.toJson(result));
    }
}