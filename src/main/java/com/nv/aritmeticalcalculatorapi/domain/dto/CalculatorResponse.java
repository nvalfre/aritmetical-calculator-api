package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CalculatorResponse {
    private String result;
}
