package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.OperationResponse;
import com.nv.aritmeticalcalculatorapi.domain.bo.OperationRequest;

public interface OperationCalculator {

    OperationResponse calculate(OperationRequest operation);

}
