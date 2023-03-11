package com.nv.aritmeticalcalculatorapi.rest;

import com.nv.aritmeticalcalculatorapi.exceptions.RandomStringGenerationException;

import java.io.IOException;
import java.util.Optional;

public interface RandomStringRestService {
    Optional<String> getRandomString();
}
