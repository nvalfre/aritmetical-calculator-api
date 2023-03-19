package com.nv.aritmeticalcalculatorapi.services.impl;


import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;
import com.nv.aritmeticalcalculatorapi.services.OperationCalculator;
import org.springframework.stereotype.Component;

@Component
public class SqrtOperationCalculator implements OperationCalculator {
    @Override
    public OperationResponse calculate(OperationRequest operation) {
        if (operation.getNum1() < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return OperationResponse.builder().result(String.valueOf(Math.sqrt(operation.getNum1()))).build();
    }
}
