package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.Pokemon;

@Service
public class PokemonService {

    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon getRandomPokemon() {
        // Generar un ID aleatorio para un Pokémon entre 1 y 1000 (puedes ajustarlo
        // según la cantidad de Pokémon disponibles)
        int randomId = (int) (Math.random() * 1000) + 1;

        // Construir la URL de la API para el Pokémon aleatorio
        String url = POKE_API_URL + randomId;

        // Crear un RestTemplate para hacer la petición
        RestTemplate restTemplate = new RestTemplate();

        // Hacer la solicitud a la PokeAPI
        String response = restTemplate.getForObject(url, String.class);

        // Procesar la respuesta (aquí simplificamos y extraemos la información
        // relevante)
        Pokemon pokemon = new Pokemon();
        pokemon.setName(response.split("\"name\":\"")[1].split("\"")[0]);
        pokemon.setImageUrl(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + randomId + ".png");
        pokemon.setDescription("A Pokémon with name " + pokemon.getName());

        return pokemon;
    }
}