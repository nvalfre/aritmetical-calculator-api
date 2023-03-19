package com.nv.aritmeticalcalculatorapi.domain.bo;


import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OperationRequest {
    private User user;
    private com.nv.aritmeticalcalculatorapi.domain.entity.Operation operation;
    private double num1;
    private double num2;
    private int length;
}
