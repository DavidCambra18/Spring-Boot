package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.SuperHero;

@Service
public class SuperHeroService {

    // Cambia este token por el tuyo real de la SuperHero API
    private static final String TOKEN = "2632b22186b9e8357db76c1239bf1350";
    private static final String API_URL = "https://superheroapi.com/api/" + TOKEN + "/";

    public SuperHero getSuperHeroObject() {
        // Por defecto buscamos el superhéroe con ID 1 (puedes parametrizarlo)
        int heroId = 1;
        String url = API_URL + heroId;

        RestTemplate restTemplate = new RestTemplate();
        SuperHero hero = restTemplate.getForObject(url, SuperHero.class);

        return hero;
    }
}
