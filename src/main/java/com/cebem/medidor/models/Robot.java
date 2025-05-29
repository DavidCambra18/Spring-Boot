package com.cebem.medidor.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "robots")
public class Robot {
    @Id
    private String id;
    private String nombre;
    private String modelo;
    private String tipo; // asalto, defensa, espionaje, médico…
    private int energiaActual;
    private int energiaMaxima;
    private int nivel;
    private List<String> habilidades;
    private String estado; // activo | dañado | destruido
    private List<String> misionesRealizadas; // IDs de misiones
}
