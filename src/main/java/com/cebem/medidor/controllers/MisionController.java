package com.cebem.medidor.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.MisionRepository;
import com.cebem.medidor.repositories.RobotRepository;

@RestController
@RequestMapping("/misiones")
public class MisionController {

    private final MisionRepository misionRepository;
    private final RobotRepository robotRepository;

    public MisionController(MisionRepository misionRepository, RobotRepository robotRepository) {
        this.misionRepository = misionRepository;
        this.robotRepository = robotRepository;
    }

    // Crear misión
    @PostMapping
    public Mision createMision(@RequestBody Mision mision) {
        return misionRepository.save(mision);
    }

    // Listar misiones
    @GetMapping
    public Iterable<Mision> getAllMisiones() {
        return misionRepository.findAll();
    }

    // Asignar robot a misión
    @PatchMapping("/{id}/asignar-robot")
    public ResponseEntity<?> asignarRobot(@PathVariable String id, @RequestParam String robotId) {
        Optional<Mision> misionOpt = misionRepository.findById(id);
        Optional<Robot> robotOpt = robotRepository.findById(robotId);
        if (misionOpt.isEmpty() || robotOpt.isEmpty())
            return ResponseEntity.notFound().build();

        Mision mision = misionOpt.get();
        Robot robot = robotOpt.get();

        // --- Comprobación opcional ---
        if (robot.getEnergiaActual() < 50) {
            return ResponseEntity.badRequest().body("El robot no tiene suficiente energía para la misión (mínimo 50).");
        }
        if (robot.getNivel() < 1) {
            return ResponseEntity.badRequest().body("El robot no tiene el nivel suficiente para la misión (mínimo 1).");
        }
        // ----------------------------

        // Añadir robot a misión si no está ya
        if (!mision.getRobotsParticipantes().contains(robotId)) {
            mision.getRobotsParticipantes().add(robotId);
            misionRepository.save(mision);
        }

        // Añadir misión realizada al robot si no está ya
        if (!robot.getMisionesRealizadas().contains(id)) {
            robot.getMisionesRealizadas().add(id);
            robotRepository.save(robot);
        }

        return ResponseEntity.ok(mision);
    }

}
