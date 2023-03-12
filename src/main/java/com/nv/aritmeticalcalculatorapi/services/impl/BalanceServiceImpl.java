package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;
import com.nv.aritmeticalcalculatorapi.domain.entity.Operation;
import com.nv.aritmeticalcalculatorapi.domain.entity.Record;
import com.nv.aritmeticalcalculatorapi.domain.entity.User;
import com.nv.aritmeticalcalculatorapi.services.BalanceService;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import com.nv.aritmeticalcalculatorapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final UserService userService;
    private final RecordService recordService;

    public BalanceDTO getBalanceByUser(String username) {
        User userByUsername = userService.getUserByUsername(username).orElseThrow(EntityNotFoundException::new);
        return BalanceDTO.builder().balance(userByUsername.getBalance()).build();
    }

    @Override
    public void save(Operation operation, User user, BigDecimal result) {
        final Record record = recordService.buildRecord(operation, user, result);
        this.update(user, operation, record);
    }

    @Override
    public void save(Operation operation, User user, String result) {
        final Record record = recordService.buildRecord(operation, user, result);
        this.update(user, operation, record);
    }

    private void update(User user, Operation operation, Record record) {
        user.setBalance(updateBalance(operation, user));
        if (user.getBalance() <= 0) {
            throw new IllegalStateException();
        }
        userService.saveUser(user);
        recordService.save(record);
    }

    private static double updateBalance(Operation operation, User user) {
        return user.getBalance() - operation.getCost().doubleValue();
    }
}
