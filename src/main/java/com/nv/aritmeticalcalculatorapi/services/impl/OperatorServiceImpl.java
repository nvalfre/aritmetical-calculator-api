package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import com.nv.aritmeticalcalculatorapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {
    private final OperationCalculator additionOperationCalculator;
    private final OperationCalculator subtractionOperationCalculator;
    private final OperationCalculator multiplicationOperationCalculator;
    private final OperationCalculator divisionOperationCalculator;
    private final OperationCalculator sqrtOperationCalculator;
    private final OperationCalculator randomStringOperationCalculator;

    private final BalanceService balanceService;
    private final UserService userService;
    private final OperationService operationService;

    @Autowired
    public OperatorServiceImpl(AdditionOperationCalculator additionOperation,
                               SubtractionOperationCalculator subtractionOperation,
                               MultiplicationOperationCalculator multiplicationOperation,
                               DivisionOperationCalculator divisionOperation,
                               SqrtOperationCalculator sqrtOperation,
                               RandomStringOperationCalculator randomStringOperation, BalanceService balanceService, UserService userService, OperationService operationService) {
        this.additionOperationCalculator = additionOperation;
        this.subtractionOperationCalculator = subtractionOperation;
        this.multiplicationOperationCalculator = multiplicationOperation;
        this.divisionOperationCalculator = divisionOperation;
        this.sqrtOperationCalculator = sqrtOperation;
        this.randomStringOperationCalculator = randomStringOperation;
        this.balanceService = balanceService;
        this.userService = userService;
        this.operationService = operationService;
    }

    public OperationResponse operate(User user, com.nv.aritmeticalcalculatorapi.domain.entity.Operation operation, CalculatorRequest calculatorRequest) {
        final OperationRequest operationRequest = OperationRequest.builder()
                .num1(calculatorRequest.getOperator1())
                .num2(calculatorRequest.getOperator2())
                .length(calculatorRequest.getLength())
                .user(user)
                .operation(operation)
                .build();
        final OperationCalculator operationCalculator = getOperationTypeCalculator(calculatorRequest.getOperationType());
        final OperationResponse response = operationCalculator.calculate(operationRequest);
        balanceService.save(operationRequest.getOperation(), operationRequest.getUser(), response.getResult());

        return response;
    }

    private OperationCalculator getOperationTypeCalculator(OperationType operator) {
        OperationCalculator operationCalculator;
        switch (operator) {
            case ADDITION:
                operationCalculator = additionOperationCalculator;
                break;
            case SUBTRACTION:
                operationCalculator = subtractionOperationCalculator;
                break;
            case MULTIPLICATION:
                operationCalculator = multiplicationOperationCalculator;
                break;
            case DIVISION:
                operationCalculator = divisionOperationCalculator;
                break;
            case SQUARE_ROOT:
                operationCalculator = sqrtOperationCalculator;
                break;
            case RANDOM_STRING:
                operationCalculator = randomStringOperationCalculator;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return operationCalculator;
    }
}
