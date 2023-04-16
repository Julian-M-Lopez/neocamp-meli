package com.meli.superheroes.application.port.in;

import com.meli.superheroes.domain.model.SuperHero;

import java.util.List;

public interface SuperHeroPortIn {
   SuperHero addSuperHero(SuperHero superHero);

   List<SuperHero> getAllSuperHeroes();

   SuperHero getSuperHeroById(Long id);
}
