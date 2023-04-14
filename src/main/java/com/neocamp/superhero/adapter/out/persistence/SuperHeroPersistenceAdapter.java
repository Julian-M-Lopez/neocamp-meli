package com.neocamp.superhero.adapter.out.persistence;

import com.neocamp.superhero.application.port.out.SuperHeroPortOut;
import com.neocamp.superhero.domain.SuperHero;

public class SuperHeroPersistenceAdapter implements SuperHeroPortOut {
    private final SuperHeroRepository superHeroRepository;

    public SuperHeroPersistenceAdapter(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero persistSuperHero(SuperHero superHero) {
        return SuperHeroMapper.entityToDomain(superHeroRepository
                .save(SuperHeroMapper.domainToEntity(superHero)));
    }
}
