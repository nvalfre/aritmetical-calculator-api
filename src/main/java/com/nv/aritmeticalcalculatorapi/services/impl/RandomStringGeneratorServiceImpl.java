package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.services.RandomStringGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class RandomStringGeneratorServiceImpl implements RandomStringGeneratorService {
    private static final int DEFAULT_LENGTH = 10;
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(DEFAULT_LENGTH);
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            char c = ALPHA_NUMERIC_STRING.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}