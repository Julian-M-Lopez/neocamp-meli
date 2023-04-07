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
    private String description;

    public  SuperHero(){

    }

    public SuperHero(long id, String nameHero, String description) {
        this.id = id;
        this.name = nameHero;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameHero() {
        return name;
    }

    public void setNameHero(String nameHero) {
        this.name = nameHero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return id == superHero.id && Objects.equals(name, superHero.name) && Objects.equals(description, superHero.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", nameHero='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
