package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;

public interface CalculatorService {
    Object calculate(Long userId, CalculatorRequest calculatorRequest);
}
