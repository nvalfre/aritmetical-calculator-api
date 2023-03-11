package com.nv.aritmeticalcalculatorapi.controllers;

import com.google.gson.Gson;
import com.nv.aritmeticalcalculatorapi.domain.dto.BalanceDTO;
import com.nv.aritmeticalcalculatorapi.domain.dto.RecordDTO;
import com.nv.aritmeticalcalculatorapi.services.BalanceService;
import com.nv.aritmeticalcalculatorapi.services.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculator/")
@RequiredArgsConstructor
public class BalanceController {
    private final BalanceService balanceService;
    private final Gson gson;

    @GetMapping(path = "/{userName}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceDTO> getBalance(@PathVariable String userName) {
        return ResponseEntity.ok(balanceService.getBalanceByUser(userName));
    }


}
