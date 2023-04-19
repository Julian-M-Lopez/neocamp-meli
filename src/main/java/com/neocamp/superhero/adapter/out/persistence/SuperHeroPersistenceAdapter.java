package com.neocamp.superhero.adapter.out.persistence;

import com.neocamp.superhero.application.port.out.SuperHeroPortOut;
import com.neocamp.superhero.common.common.PersistenceAdapter;
import com.neocamp.superhero.domain.SuperHero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
public class SuperHeroPersistenceAdapter implements SuperHeroPortOut {
    private final SuperHeroRepository superHeroRepository;

    public SuperHeroPersistenceAdapter(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero outSuperHero(SuperHero superHero) {
        return SuperHeroMapper.entityToDomain(superHeroRepository
                .save(SuperHeroMapper.domainToEntity(superHero)));
    }

    @Override
    public void outDeleteHero(Long idHero) {
        superHeroRepository.deleteById(idHero);
    }

    @Override
    public List<SuperHero> outGetAllSuperHeros() {
        return superHeroRepository.findAll().stream().map(superHeroEntity -> SuperHeroMapper.entityToDomain(superHeroEntity))
                .collect(Collectors.toList());
    }

    @Override
    public SuperHero outGetSuperHero(Long idHero) {
        return SuperHeroMapper.entityToDomain(superHeroRepository.findById(idHero).get());
    }


}
