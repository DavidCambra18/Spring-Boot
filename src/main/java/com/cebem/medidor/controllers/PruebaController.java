package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.Measure;
import com.cebem.medidor.models.RickandmortyCharacter;
import com.cebem.medidor.utils.Utils;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cebem.medidor.repositories.MeasureRepository;
import com.cebem.medidor.services.RickandmortyService;

@RestController
@RequiredArgsConstructor
public class PruebaController {

    @GetMapping("/")
    public String saluda() {
        return "Hola desde el backend!";
    }

    // http://localhost:8080/saluda

    @GetMapping("/saluda")
    public String saluda2() {
        return "Hola desde el backend!";
    }

    // http://localhost:8080/palindromo/ana
    @GetMapping("/palindromo/{word}")
    public String palindromo(@PathVariable String word) {
        return Utils.isPalindrome(word) ? "Si es palindromo" : "No es palindromo";
    }

    // http://localhost:8080/palin?word=XXX&valor=55
    @GetMapping("/palin")
    public String palin(@RequestParam String word, @RequestParam String valor) {
        return Utils.isPalindrome(word) ? "Si es palindromo" : "No es palindromo";
    }

    @PostMapping("/saveOnDisk")
    public String postMethodName(@RequestParam String usuario,
            @RequestParam String password) {
        System.out.println("body:" + usuario + ' ' + password);
        // guardar en disco la información
        return "hola";
    }

    // inyección de dependencia
    private final MeasureRepository sensorDataRepository;

    @PostMapping("/saveMeasure")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSensorData(@RequestBody Measure sensorData) {
        sensorDataRepository.save(sensorData); // Guarda los datos en la base de datos
    }

    // Ahora queremos obtener todas las mediciones que se guardado en la BD
    @GetMapping("/getMeasures")
    public ResponseEntity<List<Measure>> getAllSensorData() {
        List<Measure> sensorDataList = sensorDataRepository.findAll(); // Obtiene todas las mediciones
        return ResponseEntity.ok(sensorDataList); // Devuelve la lista de mediciones como respuesta
    }

    private final RickandmortyService rickandmortyService;

    // ejercicio 4 endpoints
    @GetMapping("/rickandmorty/random")
    public RickandmortyCharacter randomRickandmorty() {
        // obtener los datos del personaje (nombre, foto, ...)
        return rickandmortyService.getCharacterRandom();
        // return "<h2>XXXX</h2><img src='XXX.png'";
    }
}
