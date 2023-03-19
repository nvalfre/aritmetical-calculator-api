package com.nv.aritmeticalcalculatorapi.services.impl;

import com.nv.aritmeticalcalculatorapi.rest.RandomStringRestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RandomStringGeneratorServiceImplTest {

    @Mock
    private RandomStringRestService randomStringRestService;

    @InjectMocks
    private RandomStringGeneratorServiceImpl randomStringGeneratorService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateRandomString() {
        String randomstr = "strts";
        when(randomStringRestService.getRandomString(123, 123)).thenReturn(randomstr.describeConstable());

        String generate = randomStringGeneratorService.generate(123, 123);

        assertEquals(randomstr, generate);
    }
}