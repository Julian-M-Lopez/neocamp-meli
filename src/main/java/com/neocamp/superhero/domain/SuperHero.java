package com.neocamp.superhero.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SuperHero {
    private Long id;
    private String name;
    private String description;
    private boolean capa;
    private String city;
}