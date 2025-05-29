package com.cebem.medidor.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "misiones")
public class Mision {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String dificultad; // baja | media | alta
    private int recompensa;
    private List<String> robotsParticipantes; // IDs de robots
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String resultado; // pendiente | éxito | fracaso
}
