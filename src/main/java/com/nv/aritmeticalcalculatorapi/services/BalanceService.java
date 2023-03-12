package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;

import java.math.BigDecimal;

public interface BalanceService {
    BalanceDTO getBalanceByUser(String user);

    void save(Operation operation, User user, BigDecimal result);

    void save(Operation operation, User user, String result);
}
