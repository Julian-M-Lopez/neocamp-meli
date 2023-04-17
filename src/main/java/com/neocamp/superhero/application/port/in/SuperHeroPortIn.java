package com.neocamp.superhero.application.port.in;

import com.neocamp.superhero.domain.SuperHero;

import java.util.List;
import java.util.Optional;

public interface SuperHeroPortIn {



    public SuperHero addSuperHero(SuperHero superHero);
    public SuperHero getSuperHero(Long idSuperHero);
    public SuperHero getSuperHeroForName(String name);
    public List<SuperHero> getAllSuperHero();
    public void deleteSuperHero(Long idSuperHero);
    public SuperHero editSuperHero(SuperHero superHero, Long idSuperHero);
}
