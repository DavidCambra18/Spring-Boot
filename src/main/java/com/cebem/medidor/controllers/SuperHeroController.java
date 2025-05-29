package com.cebem.medidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cebem.medidor.models.SuperHero;
import com.cebem.medidor.services.SuperHeroService;

@Controller
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping("/hero")
    public String getSuperHero(Model model) {
        SuperHero hero = superHeroService.getSuperHeroObject();
        model.addAttribute("hero", hero);
        return "characterCard";
    }
}
