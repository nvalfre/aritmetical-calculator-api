package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorResponse;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import com.nv.aritmeticalcalculatorapi.services.OperationService;
import com.nv.aritmeticalcalculatorapi.services.OperatorService;
import com.nv.aritmeticalcalculatorapi.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatorServiceImplTest {

    @Mock
    private OperationService operationService;
    @Mock
    private UserService userService;
    @Mock
    private OperatorService operatorService;

    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        operationService = mock(OperationService.class);
        userService = mock(UserService.class);
        operatorService = mock(OperatorService.class);

        calculatorService = new CalculatorServiceImpl(operationService, userService, operatorService);
    }

    @Test
    void calculate_addition() {
        String userName = "testUser";
        CalculatorRequest calculatorRequest = new CalculatorRequest();
        calculatorRequest.setOperationType(OperationType.ADDITION);
        calculatorRequest.setOperator1(2.0);
        calculatorRequest.setOperator2(3.0);

        User user = new User();
        user.setUsername(userName);
        Operation operation = new Operation();
        operation.setType(OperationType.ADDITION);
        when(userService.getUserByUsername(userName)).thenReturn(Optional.of(user));
        when(operationService.getOperationByType(OperationType.ADDITION)).thenReturn(Optional.of(operation));

        CalculatorResponse calculatorResponse = calculatorService.calculate(userName, calculatorRequest);

        assertEquals(BigDecimal.valueOf(5.0).doubleValue(), calculatorResponse.getResult());
    }

    @Test
    void calculate_substraction() {
        String userName = "testUser";
        CalculatorRequest calculatorRequest = new CalculatorRequest();
        calculatorRequest.setOperationType(OperationType.SUBTRACTION);
        calculatorRequest.setOperator1(3.0);
        calculatorRequest.setOperator2(2.0);

        User user = new User();
        user.setUsername(userName);
        Operation operation = new Operation();
        operation.setType(OperationType.SUBTRACTION);
        when(userService.getUserByUsername(userName)).thenReturn(Optional.of(user));
        when(operationService.getOperationByType(OperationType.SUBTRACTION)).thenReturn(Optional.of(operation));

        CalculatorResponse calculatorResponse = calculatorService.calculate(userName, calculatorRequest);

        assertEquals(BigDecimal.valueOf(1.0).doubleValue(), calculatorResponse.getResult());
    }


}