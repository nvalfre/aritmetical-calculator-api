package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorResponse;

public interface CalculatorService {
    CalculatorResponse calculate(String userId, CalculatorRequest calculatorRequest);
}
