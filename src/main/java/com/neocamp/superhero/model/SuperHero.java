package com.neocamp.superhero.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.Objects;

@Entity
@Table(name = "superhero")
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String city;
    private String description;
    private boolean capa;

    public  SuperHero(){

    }

    public SuperHero(long id, String name, String city, String description, boolean capa) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.capa = capa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCapa() {
        return capa;
    }

    public void setCapa(boolean capa) {
        this.capa = capa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return id == superHero.id && capa == superHero.capa && Objects.equals(name, superHero.name) && Objects.equals(city, superHero.city) && Objects.equals(description, superHero.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, description, capa);
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", capa=" + capa +
                '}';
    }
}
