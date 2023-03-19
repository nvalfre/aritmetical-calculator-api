package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorResponse;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final OperationService operationService;
    private final UserService userService;
    private final OperatorService operatorService;

    @Override
    public CalculatorResponse calculate(String userName, CalculatorRequest calculatorRequest) {
        Optional<User> userById = userService.getUserByUsername(userName);
        if (userById.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Optional<Operation> operationByType = operationService.getOperationByType(calculatorRequest.getOperationType());
        if (operationByType.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final User user = userById.get();
        final Operation operation = operationByType.get();

        final OperationResponse operate = operatorService.operate(user, operation, calculatorRequest);
        return CalculatorResponse.builder()
                .result(operate.getResult())
                .build();
    }
}
