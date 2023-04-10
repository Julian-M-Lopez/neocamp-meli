package com.neocamp.superhero.service;

import com.neocamp.superhero.model.SuperHero;

import java.util.List;
import java.util.Optional;

public interface IHeroService {

    SuperHero addHero(SuperHero Hero);

    SuperHero updateHero(SuperHero Hero, Long idHero);

    List<SuperHero> listHeros();

    Optional<SuperHero> getHero(Long idHero);

    List<SuperHero> getNameHero (String name);

    void deleteHero(Long idHero);


}
