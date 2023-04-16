package com.meli.superheroes.application.service;


import com.meli.superheroes.application.port.in.SuperHeroPortIn;
import com.meli.superheroes.application.port.out.SuperHeroPortOut;
import com.meli.superheroes.domain.model.SuperHero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService implements SuperHeroPortIn {

    private final SuperHeroPortOut superHeroPortOut;

    public SuperHeroService(SuperHeroPortOut superHeroPortOut) {

        this.superHeroPortOut = superHeroPortOut;
    }

    @Override
    public SuperHero addSuperHero(SuperHero superHero) {

        return superHeroPortOut.saveSuperHero(superHero);
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        return superHeroPortOut.getAllSuperHeroes();
    }

    @Override
    public SuperHero getSuperHeroById(Long id) {
        return superHeroPortOut.getSuperHeroById(id);
    }
}
