package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.RecordDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.services.BalanceService;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import com.nv.aritmeticalcalculatorapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final UserService userService;
    private final RecordService recordService;


    public BalanceDTO getBalanceByUser(String username) {
        User userByUsername = userService.getUserByUsername(username).orElseThrow(EntityNotFoundException::new);
        List<RecordDTO> recordsByUser = recordService.getRecordsByUser(username);
        List<BigDecimal> collect = recordsByUser.stream().map(BalanceServiceImpl::getCost).toList();
        double balance = userByUsername.getBalance() - collect.stream().mapToDouble(BigDecimal::doubleValue).sum();
        return BalanceDTO.builder().balance(balance).build();
    }

    private static BigDecimal getCost(RecordDTO it) {
        return it.getOperation().getCost();
    }
}
