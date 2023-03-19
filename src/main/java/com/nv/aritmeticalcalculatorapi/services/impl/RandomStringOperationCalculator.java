package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;
import com.nv.aritmeticalcalculatorapi.services.OperationCalculator;
import com.nv.aritmeticalcalculatorapi.services.RandomStringGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomStringOperationCalculator implements OperationCalculator {
    private final RandomStringGeneratorService randomStringGeneratorService;
    @Override
    public OperationResponse calculate(OperationRequest operation) {
        String result = randomStringGeneratorService.generate((int) operation.getNum1(), operation.getLength());
        return OperationResponse.builder().result(result).build();
    }
}
