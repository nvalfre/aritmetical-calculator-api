package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorRequest;
import com.nv.aritmeticalcalculatorapi.domain.dto.CalculatorResponse;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final OperationService operationService;
    private final RecordService recordService;
    private final UserService userService;
    private final BalanceService balanceService;
    private final RandomStringGeneratorService randomStringGeneratorService;

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

        final Double operator1 = calculatorRequest.getOperator1();
        final Double operator2 = calculatorRequest.getOperator2();

        CalculatorResponse.CalculatorResponseBuilder builder = CalculatorResponse.builder();
        switch (operationByType.get().getType()) {
            case ADDITION:
                double add = add(operator1, operator2, user, operationByType.get());
                return builder.result(add).build();
            case SUBTRACTION:
                double subtract = subtract(operator1, operator2, user, operationByType.get());
                return builder.result(subtract).build();
            case MULTIPLICATION:
                double multiply = multiply(operator1, operator2, user, operationByType.get());
                return builder.result(multiply).build();
            case DIVISION:
                double divide = divide(operator1, operator2, user, operationByType.get());
                return builder.result(divide).build();
            case SQUARE_ROOT:
                double sqrt = squareRoot(operator1, user, operationByType.get());
                return builder.result(sqrt).build();
            case RANDOM_STRING:
                String s = generateRandomString(user, operationByType.get());
                return builder.randomStr(s).build();
        }
        throw new IllegalStateException();
    }

    private double add(double num1, double num2, User user, Operation operation) {
        double val = num1 + num2;
        BigDecimal result = BigDecimal.valueOf(val);
        balanceService.save(operation, user, result);
        return val;
    }

    private double subtract(double num1, double num2, User user, Operation operation) {
        double val = num1;
        BigDecimal result = BigDecimal.valueOf(val - num2);
        balanceService.save(operation, user, result);
        return val;
    }

    private double multiply(double num1, double num2, User user, Operation operation) {
        double val = num1;
        BigDecimal result = BigDecimal.valueOf(val * num2);
        balanceService.save(operation, user, result);
        return val;
    }

    private double divide(double num1, double num2, User user, Operation operation) {
        double val = num1 / num2;
        BigDecimal result = BigDecimal.valueOf(val);
        balanceService.save(operation, user, result);
        return val;
    }

    private double squareRoot(double num, User user, Operation operation) {
        double val = Math.sqrt(num);
        BigDecimal result = BigDecimal.valueOf(val);
        balanceService.save(operation, user, result);
        return val;
    }

    private String generateRandomString(User user, Operation operation) {
        String result = randomStringGeneratorService.generate().replace("\n", "");
        balanceService.save(operation, user, result);
        return result;
    }
}
