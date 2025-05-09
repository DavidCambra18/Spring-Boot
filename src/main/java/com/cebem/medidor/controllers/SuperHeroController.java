package com.cebem.medidor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.SuperHero;
import com.cebem.medidor.services.SuperHeroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @GetMapping("/hero")
    public SuperHero getHeroById(@PathVariable String id) {
        return superHeroService.obtenerHeroePorId(id);
    }
}
