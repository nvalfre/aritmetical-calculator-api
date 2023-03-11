package com.nv.aritmeticalcalculatorapi.rest.impl;

import com.nv.aritmeticalcalculatorapi.rest.RandomStringRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomStringRestServiceImpl implements RandomStringRestService {
    @Value("${baseUrl}")
    private String baseUrl;

    public Optional<String> getRandomString()  {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("num", 10)
                .queryParam("len", 10)
                .queryParam("unique", "on")
                .queryParam("format", "plain")
                .queryParam("rnd", "new")
                .queryParam("digits", "on");


        return Optional.ofNullable(restTemplate.getForObject(builder.toUriString(), String.class));
    }
}
