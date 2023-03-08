package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.Builder;

@Builder
public class CalculatorResponse {
    private Double result;
    private String randomStr;
}
