package com.nv.aritmeticalcalculatorapi.rest;

import java.util.Optional;

public interface RandomStringRestService {
    Optional<String> getRandomString(double num, int length);
}
