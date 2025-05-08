package com.cebem.medidor.services;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.Pokemon;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final int TOTAL_POKEMON = 898; // Hasta la generación 8
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final Random random;

    public PokemonService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.random = new Random();
    }

    public Pokemon getRandomPokemon() {
        try {
            int randomId = random.nextInt(TOTAL_POKEMON) + 1;
            log.info("Obteniendo información del Pokémon con ID: {}", randomId);

            String response = restTemplate.getForObject(POKEAPI_URL + randomId, String.class);
            JsonNode rootNode = objectMapper.readTree(response);

            Pokemon pokemon = new Pokemon();
            pokemon.setId(rootNode.get("id").asInt());
            pokemon.setName(capitalizeFirstLetter(rootNode.get("name").asText()));
            pokemon.setHeight(rootNode.get("height").asInt());
            pokemon.setWeight(rootNode.get("weight").asInt());

            // Mapeando tipos
            pokemon.setTypes(objectMapper.readValue(
                    rootNode.get("types").toString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Pokemon.Type.class)));

            // Mapeando sprites
            Pokemon.Sprites sprites = new Pokemon.Sprites();
            sprites.setFrontDefault(rootNode.get("sprites").get("front_default").asText());

            Pokemon.Sprites.Other other = new Pokemon.Sprites.Other();
            Pokemon.Sprites.Other.OfficialArtwork officialArtwork = new Pokemon.Sprites.Other.OfficialArtwork();

            // Acceder a official-artwork si existe
            if (rootNode.get("sprites").get("other").has("official-artwork") &&
                    rootNode.get("sprites").get("other").get("official-artwork").has("front_default")) {
                officialArtwork.setFrontDefault(
                        rootNode.get("sprites").get("other").get("official-artwork").get("front_default").asText());
            } else {
                // Si no existe, usar el sprite normal
                officialArtwork.setFrontDefault(sprites.getFrontDefault());
            }

            other.setOfficialArtwork(officialArtwork);
            sprites.setOther(other);
            pokemon.setSprites(sprites);

            // Mapeando stats
            pokemon.setStats(objectMapper.readValue(
                    rootNode.get("stats").toString(),
                    objectMapper.getTypeFactory().constructCollectionType(
                            List.class, Pokemon.Stat.class)));

            // Obteniendo especie
            pokemon.setSpecies(rootNode.get("species").get("name").asText());

            return pokemon;
        } catch (Exception e) {
            log.error("Error al obtener información del Pokémon: {}", e.getMessage());
            return null;
        }
    }

    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}