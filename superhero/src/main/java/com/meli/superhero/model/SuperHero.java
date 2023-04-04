package com.meli.superhero.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "super_hero")
@Data
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSuperHero;

    private String nombre;

    private String descripcion;

    private boolean capa;

    private int puntosPoder;

    private int puntosDefensa;

    private int puntosVelocidad;


}
