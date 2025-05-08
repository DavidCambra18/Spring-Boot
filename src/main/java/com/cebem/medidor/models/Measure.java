package com.cebem.medidor.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mac; // Dirección MAC del sensor (se recibe desde el ESP32)
    private double temperature; // Temperatura medida por el sensor
    private double humidity; // Humedad medida por el sensor
    private double solarRadiation; // Radiación solar medida por el sensor

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Fecha y hora de la creación del registro

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}