package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.RickandmortyCharacter;


@Service
public class RickandmortyService {
    
    private final RestTemplate restTemplate;

    public RickandmortyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RickandmortyCharacter getCharacterRandom(){
        String url = "https://rickandmortyapi.com/api/character/" + (int) (Math.random() * 826 + 1); // Hay 826 personajes en la API
        return restTemplate.getForObject(url, RickandmortyCharacter.class);
    }

}
