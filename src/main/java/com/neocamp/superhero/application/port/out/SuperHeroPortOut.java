package com.neocamp.superhero.application.port.out;

import com.neocamp.superhero.domain.SuperHero;

import java.util.List;
import java.util.Optional;

public interface SuperHeroPortOut {
    public SuperHero persistSuperHero(SuperHero superHero);
    public Optional<SuperHero> getSuperHero(Long idSuperHero);
    public  Optional<SuperHero> getSuperHeroForName(String name);
    public List<SuperHero> getAllSuperHero();
    public void deleteSuperhero(Long idSuperHero);
}
