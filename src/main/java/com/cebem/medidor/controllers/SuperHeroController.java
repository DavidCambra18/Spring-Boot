package com.cebem.medidor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.services.SuperHeroService;

@RestController
@RequestMapping("/hero")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping
    public ResponseEntity<String> getSuperHero() {
        String resultado = superHeroService.getSuperHeroInfo();
        return ResponseEntity.ok(resultado);
    }
}
