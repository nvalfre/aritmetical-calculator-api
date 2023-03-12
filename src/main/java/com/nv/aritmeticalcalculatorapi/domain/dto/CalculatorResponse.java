package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CalculatorResponse {
    private Double result;
    private String randomStr;
}
