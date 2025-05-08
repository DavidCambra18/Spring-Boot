package com.cebem.medidor.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cebem.medidor.models.Pokemon;
import com.cebem.medidor.services.PokemonService;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public String getRandomPokemon(Model model) {
        // Obtener el Pokémon aleatorio
        Pokemon pokemon = pokemonService.getRandomPokemon();
        
        // Pasar el Pokémon al modelo para ser mostrado en la vista
        model.addAttribute("pokemon", pokemon);
        
        return "pokemon-card";  // Nombre de la vista que generaremos
    }
}