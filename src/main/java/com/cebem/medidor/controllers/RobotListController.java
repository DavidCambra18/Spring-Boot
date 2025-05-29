package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.MisionRepository;
import com.cebem.medidor.repositories.RobotRepository;

@Controller
public class RobotListController {
    private final RobotRepository robotRepository;
    private final MisionRepository misionRepository;

    public RobotListController(RobotRepository robotRepository, MisionRepository misionRepository) {
        this.robotRepository = robotRepository;
        this.misionRepository = misionRepository;
    }

    @GetMapping("/robots/lista")
    public String robotsLista(Model model) {
        model.addAttribute("robots", robotRepository.findAll());
        return "robots";
    }

    @GetMapping("/robots/{id}/historial")
    public String historialMisiones(@PathVariable String id, Model model) {
        Robot robot = robotRepository.findById(id).orElse(null);
        if (robot == null)
            return "redirect:/robots/lista";
        List<Mision> misiones = misionRepository.findAllById(robot.getMisionesRealizadas());
        model.addAttribute("robot", robot);
        model.addAttribute("misiones", misiones);
        return "historial-robot";
    }
}