package com.meli.superheroes.application.port.out;

import com.meli.superheroes.domain.model.SuperHero;

import java.util.List;

public interface SuperHeroPortOut {
    SuperHero saveSuperHero(SuperHero superHero);
    SuperHero updateSuperHero(Long id, SuperHero superHero);
    void deleteSuperHero(Long superHeroId);
    SuperHero getSuperHeroById(Long superHeroId);
    List<SuperHero> getSuperHeroesByName(String name);

    List<SuperHero> getAllSuperHeroes();
}
