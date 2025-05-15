package com.cebem.medidor.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SuperHeroService {

    @Value("${superheroapi.url}")
    private String superheroApiUrl;

    @Value("${superheroapi.token}")
    private String superheroApiToken;

    public String getSuperHeroInfo() {
        RestTemplate restTemplate = new RestTemplate();
        String url = superheroApiUrl + "/" + superheroApiToken + "/1";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
