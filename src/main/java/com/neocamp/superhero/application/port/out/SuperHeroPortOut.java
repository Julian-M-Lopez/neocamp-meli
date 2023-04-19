package com.neocamp.superhero.application.port.out;

import com.neocamp.superhero.domain.SuperHero;

import java.util.List;

public interface SuperHeroPortOut {
    SuperHero outSuperHero(SuperHero superHero);

    void outDeleteHero(Long idHero);

    List<SuperHero> outGetAllSuperHeros();

    SuperHero outGetSuperHero(Long idHero);

}
