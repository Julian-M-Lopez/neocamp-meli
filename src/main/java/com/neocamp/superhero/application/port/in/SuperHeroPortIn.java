package com.neocamp.superhero.application.port.in;

import com.neocamp.superhero.domain.SuperHero;

import java.util.List;

public interface SuperHeroPortIn {
    SuperHero addSuperHero(SuperHero superHero);

    void deleteHero(Long idHero);

    List<SuperHero> getAllSuperheros();

    SuperHero getSuperHero(Long idHero);
}
