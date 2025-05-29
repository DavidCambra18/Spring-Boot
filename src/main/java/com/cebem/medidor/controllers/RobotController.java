package com.cebem.medidor.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.RobotRepository;

@RestController
@RequestMapping("/robots")
public class RobotController {

    private final RobotRepository robotRepository;

    public RobotController(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    // Crear robot
    @PostMapping
    public Robot createRobot(@RequestBody Robot robot) {
        return robotRepository.save(robot);
    }

    // Listar robots
    @GetMapping
    public Iterable<Robot> getAllRobots() {
        return robotRepository.findAll();
    }

    // Recargar energía al máximo
    @PatchMapping("/{id}/recargar")
    public ResponseEntity<?> recargarEnergia(@PathVariable String id) {
        Optional<Robot> robotOpt = robotRepository.findById(id);
        if (robotOpt.isEmpty()) return ResponseEntity.notFound().build();
        Robot robot = robotOpt.get();
        robot.setEnergiaActual(robot.getEnergiaMaxima());
        robotRepository.save(robot);
        return ResponseEntity.ok(robot);
    }

    // Subir nivel
    @PatchMapping("/{id}/subir-nivel")
    public ResponseEntity<?> subirNivel(@PathVariable String id) {
        Optional<Robot> robotOpt = robotRepository.findById(id);
        if (robotOpt.isEmpty()) return ResponseEntity.notFound().build();
        Robot robot = robotOpt.get();
        robot.setNivel(robot.getNivel() + 1);
        robotRepository.save(robot);
        return ResponseEntity.ok(robot);
    }
}
