package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;

public interface OperatorService {
    OperationResponse operate(User user, com.nv.aritmeticalcalculatorapi.domain.entity.Operation operation, CalculatorRequest calculatorRequest);
}
