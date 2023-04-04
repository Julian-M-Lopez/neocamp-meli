package com.meli.superhero.model;

import lombok.Data;
import javax.persistence.*;

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
