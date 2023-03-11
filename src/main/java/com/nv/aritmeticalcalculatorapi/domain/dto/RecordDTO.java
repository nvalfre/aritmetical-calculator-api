package com.nv.aritmeticalcalculatorapi.domain.dto;

import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RecordDTO {
    private String id;
    private Operation operation;
    private String userId;
    private BigDecimal amount;
    private BigDecimal userBalance;
}
