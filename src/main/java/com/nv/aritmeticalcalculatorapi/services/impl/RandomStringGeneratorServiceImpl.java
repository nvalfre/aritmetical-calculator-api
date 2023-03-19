package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.rest.RandomStringRestService;
import com.nv.aritmeticalcalculatorapi.services.RandomStringGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class RandomStringGeneratorServiceImpl implements RandomStringGeneratorService {
    private static final int DEFAULT_NUM = 10;
    private final RandomStringRestService randomStringRestService;

    public String generate(int num, int length) {
        try {
            Optional<String> randomString = randomStringRestService.getRandomString(getNum(num), getLength(length));
            return randomString.orElseThrow(IllegalArgumentException::new).replace("\n", "");
        } catch (Exception e) {
            log.error("Error generating random string: ", e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static int getLength(int length) {
        return length > 0 && length <= 20 ? length : DEFAULT_NUM;
    }

    private static double getNum(double num) {
        return num > 0 && num <= 20 ? num : DEFAULT_NUM;
    }
}