package com.neocamp.superhero.service;

import com.neocamp.superhero.model.SuperHero;

import java.util.List;
import java.util.Optional;

public interface IHeroService {

    SuperHero addHero(SuperHero Hero);

    SuperHero updateHero(SuperHero Hero);

    List<SuperHero> listHeros();

    Optional<SuperHero> getHero(Long idHero);

    void deleteHero(Long idHero);


}
