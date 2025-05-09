package com.cebem.medidor.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cebem.medidor.models.SuperHero;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SuperHeroService {

    @Value("${superheroapi.url}")
    private String superheroApiUrl;

    @Value("${superheroapi.token}")
    private String superheroApiToken;

    private final RestTemplate restTemplate;

    public SuperHeroService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SuperHero obtenerHeroePorId(String id) {
        // Construir la URL con los parámetros
        String url = UriComponentsBuilder.fromHttpUrl(superheroApiUrl)
                .path("/api/hero/{id}")
                .queryParam("token", superheroApiToken)
                .buildAndExpand(id)
                .toUriString();

        // Realizar la llamada HTTP GET y mapear la respuesta a la clase SuperHero
        return restTemplate.getForObject(url, SuperHero.class);
    }
}
