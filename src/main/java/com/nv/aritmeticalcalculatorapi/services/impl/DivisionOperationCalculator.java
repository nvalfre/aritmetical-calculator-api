package com.nv.aritmeticalcalculatorapi.services.impl;


import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;
import com.nv.aritmeticalcalculatorapi.services.OperationCalculator;
import org.springframework.stereotype.Component;

@Component
public class DivisionOperationCalculator implements OperationCalculator {
    @Override
    public OperationResponse calculate(OperationRequest operation) {
        if (operation.getNum2() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return OperationResponse.builder().result(String.valueOf(operation.getNum1() / operation.getNum2())).build();
    }
}