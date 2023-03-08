package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import com.nv.aritmeticalcalculatorapi.repository.OperationRepository;
import com.nv.aritmeticalcalculatorapi.services.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }

    @Override
    public Operation saveOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void deleteOperationById(Long id) {
        operationRepository.deleteById(id);
    }

    @Override
    public Optional<Operation> getOperationByType(OperationType addition){
        return operationRepository.findByType(addition);
    }
}
