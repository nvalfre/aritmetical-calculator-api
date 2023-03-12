package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import com.nv.aritmeticalcalculatorapi.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BalanceServiceImplTest {

    private BalanceServiceImpl balanceService;
    private UserService userService;
    private RecordService recordService;
    private User testUser;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        recordService = mock(RecordService.class);
        balanceService = new BalanceServiceImpl(userService, recordService);
        testUser = new User("testUser", "testUser", "testUser", 100.0, true);
    }

    @Test
    void testGetBalanceByUser() {
        when(userService.getUserByUsername("testUser")).thenReturn(java.util.Optional.ofNullable(testUser));

        BalanceDTO balanceDTO = balanceService.getBalanceByUser("testUser");

        Assertions.assertEquals(BigDecimal.valueOf(100.0).doubleValue(), balanceDTO.getBalance().doubleValue());
    }

    @Test
    void testSaveOperation() {
        Operation operation = new Operation();
        operation.setCost(BigDecimal.valueOf(10));

        balanceService.save(operation, testUser, BigDecimal.valueOf(90));

        Assertions.assertEquals(BigDecimal.valueOf(90.0).doubleValue(), testUser.getBalance().doubleValue());
    }

    @Test
    void testSaveOperationWithInsufficientBalance() {
        Operation operation = new Operation();
        operation.setCost(BigDecimal.valueOf(110));
        Assertions.assertThrows(IllegalStateException.class, () -> balanceService.save(operation, testUser, BigDecimal.valueOf(90)));
    }
}