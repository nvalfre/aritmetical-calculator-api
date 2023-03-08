package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;

import java.util.List;
import java.util.Optional;

public interface OperationService {
    List<Operation> getAllOperations();

    Optional<Operation> getOperationById(Long id);

    Operation saveOperation(Operation operation);

    void deleteOperationById(Long id);

    Optional<Operation> getOperationByType(OperationType addition);
}
