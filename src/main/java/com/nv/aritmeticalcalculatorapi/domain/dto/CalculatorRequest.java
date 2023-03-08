package com.nv.aritmeticalcalculatorapi.domain.dto;

import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import lombok.Data;

@Data
public class CalculatorRequest {
    private Double operator1;
    private Double operator2;
    private Integer length;
    private OperationType operationType;
}
