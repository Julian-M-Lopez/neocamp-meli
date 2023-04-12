package com.neocamp.superhero.model;

//import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "SUPERHERO")
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean capa;

    private String city;




}
