package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import com.nv.aritmeticalcalculatorapi.repository.OperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OperationServiceImplTest {

    @Mock
    private OperationRepository operationRepository;

    @InjectMocks
    private OperationServiceImpl operationService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOperations() {
        List<Operation> expectedOperations = new ArrayList<>();
        expectedOperations.add(new Operation(1L, OperationType.ADDITION, BigDecimal.ONE));
        expectedOperations.add(new Operation(2L, OperationType.SUBTRACTION, BigDecimal.ONE));
        expectedOperations.add(new Operation(3L, OperationType.MULTIPLICATION, BigDecimal.TEN));

        Mockito.when(operationRepository.findAll()).thenReturn(expectedOperations);

        List<Operation> actualOperations = operationService.getAllOperations();

        assertEquals(expectedOperations.size(), actualOperations.size());
        for (int i = 0; i < expectedOperations.size(); i++) {
            assertEquals(expectedOperations.get(i).getId(), actualOperations.get(i).getId());
            assertEquals(expectedOperations.get(i).getType(), actualOperations.get(i).getType());
            assertEquals(expectedOperations.get(i).getCost(), actualOperations.get(i).getCost());
        }
    }

    @Test
    public void testGetOperationById() {
        Long operationId = 1L;
        Operation expectedOperation = new Operation(operationId, OperationType.ADDITION, BigDecimal.ONE);

        Mockito.when(operationRepository.findById(operationId)).thenReturn(Optional.of(expectedOperation));

        Optional<Operation> actualOperation = operationService.getOperationById(operationId);

        assertTrue(actualOperation.isPresent());
        assertEquals(expectedOperation.getId(), actualOperation.get().getId());
        assertEquals(expectedOperation.getType(), actualOperation.get().getType());
        assertEquals(expectedOperation.getCost(), actualOperation.get().getCost());
    }

    @Test
    public void testSaveOperation() {
        Operation operationToSave = new Operation(null, OperationType.DIVISION, BigDecimal.TEN);
        Operation expectedOperation = new Operation(1L, OperationType.DIVISION, BigDecimal.TEN);

        Mockito.when(operationRepository.save(operationToSave)).thenReturn(expectedOperation);

        Operation actualOperation = operationService.saveOperation(operationToSave);

        assertEquals(expectedOperation.getId(), actualOperation.getId());
        assertEquals(expectedOperation.getType(), actualOperation.getType());
        assertEquals(expectedOperation.getCost(), actualOperation.getCost());
    }

    @Test
    public void testDeleteOperationById() {
        Long operationId = 1L;

        operationService.deleteOperationById(operationId);

        Mockito.verify(operationRepository, Mockito.times(1)).deleteById(operationId);
    }

    @Test
    public void testGetOperationByType() {
        OperationType operationType = OperationType.SUBTRACTION;
        Operation expectedOperation = new Operation(2L, OperationType.SUBTRACTION, BigDecimal.ONE);

        Mockito.when(operationRepository.findByType(operationType)).thenReturn(Optional.of(expectedOperation));

        Optional<Operation> actualOperation = operationService.getOperationByType(operationType);

        assertTrue(actualOperation.isPresent());
        assertEquals(expectedOperation.getId(), actualOperation.get().getId());
        assertEquals(expectedOperation.getType(), actualOperation.get().getType());
        assertEquals(expectedOperation.getCost(), actualOperation.get().getCost());
    }
}