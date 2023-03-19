package com.nv.aritmeticalcalculatorapi.services.impl;


import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;
import com.nv.aritmeticalcalculatorapi.services.OperationCalculator;
import org.springframework.stereotype.Component;

@Component
public class MultiplicationOperationCalculator implements OperationCalculator {
    @Override
    public OperationResponse calculate(OperationRequest operation) {
        return OperationResponse.builder().result(String.valueOf(operation.getNum1() * operation.getNum2())).build();
    }
}