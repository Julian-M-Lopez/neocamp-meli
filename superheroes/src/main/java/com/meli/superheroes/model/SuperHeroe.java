package com.meli.superheroes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuperHeroe {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion = "";
    private boolean capa = false;
}

    //Codigo omitiod por Lombok
 /*
    // Metodos constructor
    public SuperHeroe(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Metodos personalizados
    @Override
    public String toString() {
        return "(Nombre): " + nombre + ", Descripcion: " + descripcion + ", Capa: " + capa;
    }

    // Metodos getter y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCapa() {
        return capa;
    }

    public void setCapa(Boolean capa) {
        this.capa = capa;
    }
}
*/