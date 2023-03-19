package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponse {
    private String result;
}
