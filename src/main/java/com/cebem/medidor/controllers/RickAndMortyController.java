package com.cebem.medidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cebem.medidor.models.RickandmortyCharacter;
import com.cebem.medidor.services.RickandmortyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RickAndMortyController {

    //private final RestTemplate restTemplate;
    private final RickandmortyService rickandmortyService;
   

    @GetMapping("/rickandmortyweb")
    public String getRandomCharacter(Model model) {
        RickandmortyCharacter character = rickandmortyService.getCharacterRandom();
        // Agregar el personaje al modelo de Thymeleaf
        model.addAttribute("character", character);
        // Devolver el nombre del template
        return "characterCard";
    }
}
