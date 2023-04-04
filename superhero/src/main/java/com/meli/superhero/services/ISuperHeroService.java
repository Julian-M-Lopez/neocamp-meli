package com.meli.superhero.services;

import com.meli.superhero.model.SuperHero;

import java.util.List;
import java.util.Optional;


public interface ISuperHeroService {

    SuperHero addHero(SuperHero superHero);

    SuperHero updateHero(SuperHero superHero);

    List<SuperHero> listHeros();

    Optional<SuperHero> getHero(int idHero);

    void deleteHero(int idHero);
}
