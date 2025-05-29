package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.repositories.MisionRepository;

@Controller
public class MisionListController {
    private final MisionRepository misionRepository;

    public MisionListController(MisionRepository misionRepository) {
        this.misionRepository = misionRepository;
    }

    @GetMapping("/misiones/lista")
    public String misionesLista(
            @RequestParam(required = false) String dificultad,
            @RequestParam(required = false, name = "estado") String resultado,
            Model model) {
        List<Mision> misiones;
        if ((dificultad == null || dificultad.isEmpty()) && (resultado == null || resultado.isEmpty())) {
            misiones = misionRepository.findAll();
        } else if (dificultad != null && !dificultad.isEmpty() && (resultado == null || resultado.isEmpty())) {
            misiones = misionRepository.findByDificultad(dificultad);
        } else if ((dificultad == null || dificultad.isEmpty()) && resultado != null && !resultado.isEmpty()) {
            misiones = misionRepository.findByResultado(resultado);
        } else {
            misiones = misionRepository.findByDificultadAndResultado(dificultad, resultado);
        }
        model.addAttribute("misiones", misiones);
        return "misiones";
    }
}