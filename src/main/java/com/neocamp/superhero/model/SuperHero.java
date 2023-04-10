package com.neocamp.superhero.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.Objects;

@Entity
@Data
@Table(name = "SUPERHERO")
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String city;

    private String description;

    private boolean capa;


}
