package com.nv.aritmeticalcalculatorapi.services;

import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;

public interface BalanceService {
    BalanceDTO getBalanceByUser(String user);
}
